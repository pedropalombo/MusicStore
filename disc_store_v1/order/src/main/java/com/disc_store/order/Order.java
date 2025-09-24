package com.disc_store.order;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private Long customerId;

    @ElementCollection
    private List<Long> listOfCds;

    private Double totalPrice;

    // empty constructor for Spring to use
    public Order() {}

    public Order(Long customerId, List<Long> listOfCds, Double totalPrice) {
        this.customerId = customerId;
        this.listOfCds = listOfCds;
        this.totalPrice = totalPrice;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public List<Long> getListOfCds() { return listOfCds; }
    public void setListOfCds(List<Long> listOfCds) { this.listOfCds = listOfCds; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
}