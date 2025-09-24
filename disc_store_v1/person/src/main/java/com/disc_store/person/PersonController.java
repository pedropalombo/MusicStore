package com.disc_store.person;

import java.math.BigDecimal;
import java.util.List;
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
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;
    private final OrderProxy orderProxy;

    public PersonController(PersonService service, OrderProxy orderProxy) {
        this.service = service;
        this.orderProxy = orderProxy;
    }

    @GetMapping
    public List<Person> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Optional<Person> getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Person create(@RequestBody Person person) { return service.save(person); }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return service.getById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setCashbackTotal(updatedPerson.getCashbackTotal());
                    return service.save(person);
                })
                .orElseGet(() -> {
                    updatedPerson.setId(id);
                    return service.save(updatedPerson);
                });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/{personId}/order")
    public List<Object> getOrdersForPerson(@PathVariable Long personId) {
        return orderProxy.getOrdersByPerson(personId);
    }
    
    @PutMapping("/{id}/cashback")
    public void updateCashback(@PathVariable Long id, @RequestBody BigDecimal newCashback) {
        service.getById(id).ifPresent(person -> {
            person.setCashbackTotal(newCashback);
            service.save(person);
        });
    }
}
