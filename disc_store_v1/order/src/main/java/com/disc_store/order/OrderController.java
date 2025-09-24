package com.disc_store.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;
    private final PersonProxy personProxy;
    private final DiscProxy discProxy;

    public OrderController(OrderService service, PersonProxy personProxy, DiscProxy discProxy) {
        this.service = service;
        this.personProxy = personProxy;
        this.discProxy = discProxy;
    }

    // --- CRUD ---
    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        Order savedOrder = service.save(order);

        // --- Cashback calculation ---
        double cashbackRate = 0.10; // 10%
        double cashbackAmount = savedOrder.getTotalPrice() * cashbackRate;

        // Fetch current cashback from Person service
        Map<String, Object> personData = (Map<String, Object>) personProxy.getPersonById(savedOrder.getCustomerId());
        double currentCashback = ((Number) personData.get("cashbackTotal")).doubleValue();
        double newCashback = currentCashback + cashbackAmount;

        // Update cashback in Person service
        personProxy.updatePersonCashback(savedOrder.getCustomerId(), BigDecimal.valueOf(newCashback));

        return savedOrder;
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order updatedOrder) {
        return service.getById(id)
                .map(order -> {
                    order.setCustomerId(updatedOrder.getCustomerId());
                    order.setListOfCds(updatedOrder.getListOfCds());
                    order.setTotalPrice(updatedOrder.getTotalPrice());
                    return service.save(order);
                })
                .orElseGet(() -> {
                    updatedOrder.setId(id);
                    return service.save(updatedOrder);
                });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // --- Get Orders by PersonId ---
    @GetMapping("/person/{personId}")
    public List<Order> getByPersonId(@PathVariable Long personId) {
        return service.getByCustomerId(personId);
    }

    // --- Get Order Details (Person + Discs) ---
    @GetMapping("/details/{orderId}")
    public Map<String, Object> getOrderDetails(@PathVariable Long orderId) {
        Order order = service.getById(orderId)
                             .orElseThrow(() -> new RuntimeException("Order not found"));

        // Fetch Person info
        Object person = personProxy.getPersonById(order.getCustomerId());

        // Fetch Disc info for all discs in the order
        List<Object> discs = order.getListOfCds().stream()
                                  .map(discProxy::getDiscById)
                                  .toList();

        return Map.of(
            "order", order,
            "customer", person,
            "discs", discs
        );
    }
}