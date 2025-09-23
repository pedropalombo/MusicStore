package com.disc_store.order;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	// fetching the methods for 'Order'
	private final OrderService orderService;

	// constructor
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping(path="/order")
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
		return ResponseEntity.ok(orderService.createOrder(orderDTO));
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
		return ResponseEntity.ok(orderService.getOrderById(id));
	}

	@GetMapping(path="/order")
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		return ResponseEntity.ok(orderService.getAllOrders());
	}

	@GetMapping("/person/{personId}/order")
	public ResponseEntity<List<OrderDTO>> getOrdersByPerson(@PathVariable Long personId) {
		return ResponseEntity.ok(orderService.getOrdersByPerson(personId));
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/order/{id}/cashback")
	public ResponseEntity<Double> getOrderCashback(@PathVariable Long id) {
		return ResponseEntity.ok(orderService.calculateCashbackForOrder(id));
	}
}
