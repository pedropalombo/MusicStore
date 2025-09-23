package com.disc_store.person;

import java.math.BigDecimal;

public class PersonDTO {
	private Long id;
    private String name;
    private BigDecimal cashbackTotal;

    // Constructors
    public PersonDTO() {
    }

    // -- Auto-generated constructor, getters/setters, and toString() --
    public PersonDTO(Long id, String name, BigDecimal cashbackTotal) {
        this.id = id;
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
