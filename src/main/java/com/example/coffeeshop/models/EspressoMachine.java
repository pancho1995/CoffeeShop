package com.example.coffeeshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class EspressoMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private Integer grinder;
    @JsonIgnore
    @OneToOne(mappedBy = "espressoMachine")
    private Barista barista;

    public EspressoMachine(String brand, Integer grinder, Barista barista) {
        this.brand = brand;
        this.grinder = grinder != null ? grinder : 300;
        this.barista = barista;
    }

    public EspressoMachine() {
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getGrinder() {
        return grinder;
    }

    public void setGrinder(Integer grinder) {
        this.grinder = grinder;
    }

    public Barista getBarista() {
        return barista;
    }

    public void setBarista(Barista barista) {
        this.barista = barista;
    }
}
