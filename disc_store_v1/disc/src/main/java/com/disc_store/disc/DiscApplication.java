package com.disc_store.disc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DiscApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscApplication.class, args);
	}

}
