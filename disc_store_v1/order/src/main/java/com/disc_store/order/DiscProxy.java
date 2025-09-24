package com.disc_store.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "disc-service", url = "http://localhost:8300")
public interface DiscProxy {

    @GetMapping("/disc/{id}")
    Object getDiscById(@PathVariable("id") Long id);
}