package com.disc_store.order;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "person-service", url = "http://localhost:8100")
public interface PersonProxy {

	@GetMapping("/person/{id}")
    Object getPersonById(@PathVariable("id") Long id);

    @PutMapping("/person/{id}/cashback")
    void updatePersonCashback(@PathVariable("id") Long id, @RequestBody BigDecimal newCashback);
}