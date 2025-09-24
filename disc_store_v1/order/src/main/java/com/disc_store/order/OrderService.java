package com.disc_store.order;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Optional<Order> getById(Long id) {
        return repository.findById(id);
    }

    public List<Order> getByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public Order save(Order order) {
        return repository.save(order);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
