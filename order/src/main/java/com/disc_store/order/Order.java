package com.disc_store.order;

import java.math.BigDecimal;
import java.util.List;

import com.disc_store.disc.domain.Disc; // if needed
import com.disc_store.person.domain.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany
    @JoinTable(
        name = "order_discs",
        joinColumns = @JoinColumn(name = "order_id"),	// using 'Order's PK to join with 'Disc's
        inverseJoinColumns = @JoinColumn(name = "disc_id")	// '' 'Disc's PK '' 'Order's
    )
    private List<Disc> discs;

    private BigDecimal totalPrice;

    // empty constructor to be used by Spring
    public Order() {
    }
    
    // Helper method to calculate total price
    public void calculateTotalPrice() {
        this.totalPrice = discs
        		.stream()
                .map(Disc::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // -- Auto-generated constructor, getters/setters, and toString() --
    public Order(Person person, List<Disc> discs, BigDecimal totalPrice) {
        this.person = person;
        this.discs = discs;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Disc> getDiscs() {
        return discs;
    }

    public void setDiscs(List<Disc> discs) {
        this.discs = discs;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    // -- / --
}