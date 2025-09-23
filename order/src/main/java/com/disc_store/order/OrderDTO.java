package com.disc_store.order;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Long personId;
    private List<Long> discIds;
    private BigDecimal totalPrice;

    // empty constructor to be used by Spring
    public OrderDTO() {
    }

    // -- Auto-generated constructor, getters/setters, and toString() --
    public OrderDTO(Long id, Long personId, List<Long> discIds, BigDecimal totalPrice) {
        this.id = id;
        this.personId = personId;
        this.discIds = discIds;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public List<Long> getDiscIds() {
        return discIds;
    }

    public void setDiscIds(List<Long> discIds) {
        this.discIds = discIds;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    // -- / --
}