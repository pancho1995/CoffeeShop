package com.example.coffeeshop.filters;

import com.example.coffeeshop.enums.OrderEnum;
import com.example.coffeeshop.services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ToGoPendingOrdersFilter extends OncePerRequestFilter {

    private final OrderService orderService;
    private final HttpServletResponse httpServletResponse;
    private final ObjectMapper objectMapper;

    @Autowired
    public ToGoPendingOrdersFilter(OrderService orderService,
                                   HttpServletResponse httpServletResponse,
                                   ObjectMapper objectMapper) {
        this.orderService = orderService;
        this.httpServletResponse = httpServletResponse;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        boolean isCapacityAchieved = this.orderService.countOrderByStatusIsAndType(OrderEnum.Status.PENDING,
                OrderEnum.Type.TO_GO) >= 5;
        if (request.getRequestURI().equals("/api/v1/order/to-go") && isCapacityAchieved) {

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    objectMapper.writeValueAsString("Login first"));

            return;
        }
        filterChain.doFilter(request, response);
    }
}