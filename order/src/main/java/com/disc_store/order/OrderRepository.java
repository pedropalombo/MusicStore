package com.disc_store.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository		// injecting JPA methods to the class
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByPersonId(Long personId);

}
