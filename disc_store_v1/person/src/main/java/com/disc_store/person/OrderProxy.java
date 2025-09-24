package com.disc_store.person;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8200")
public interface OrderProxy {

    @GetMapping("/person/{personId}/order")  // matches Order service URL structure
    List<Object> getOrdersByPerson(@PathVariable("personId") Long personId);
}