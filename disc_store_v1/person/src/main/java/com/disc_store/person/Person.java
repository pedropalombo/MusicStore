package com.disc_store.person;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity(name = "person")
@Table(name="persons")
public class Person {

	@Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal cashbackTotal;


    // empty constructor to be used by Spring
    public Person() {
    }

    // -- Auto-generated constructor, getters/setters, and toString() --
    public Person(String name, BigDecimal cashbackTotal) {
        this.name = name;
        this.cashbackTotal = cashbackTotal;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCashbackTotal() {
        return cashbackTotal;
    }

    public void setCashbackTotal(BigDecimal cashbackTotal) {
        this.cashbackTotal = cashbackTotal;
    }
    // -- / --
}
