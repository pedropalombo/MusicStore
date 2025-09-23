package com.disc_store.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	// instancing the dbs for everyone involved with the order (customer, order, and CD)
	private final OrderRepository orderRepository;
	private final PersonRepository personRepository;
	private final DiscRepository discRepository;

	// constructor
	public OrderServiceImpl(OrderRepository orderRepository, PersonRepository personRepository,
			DiscRepository discRepository) {
		this.orderRepository = orderRepository;
		this.personRepository = personRepository;
		this.discRepository = discRepository;
	}
	
	// converter for 'Order' -> 'OrderDTO'
	private OrderDTO mapToDTO(Order order) {
		List<Long> discIds = order.getDiscs().stream().map(Disc::getId).collect(Collectors.toList());
		return new OrderDTO(order.getId(), order.getPerson().getId(), discIds, order.getTotalPrice());
	}

	@Override
	public OrderDTO createOrder(OrderDTO orderDTO) {
		
		// finds the customer by their id
		Person person = personRepository.findById(orderDTO.getPersonId())
				.orElseThrow(() -> new RuntimeException("Person not found"));	// throwing an exception if nothing is found

		// finds the disc by its id
		List<Disc> discs = orderDTO.getDiscIds()
				.stream()	
				.map(id -> discRepository.findById(id).orElseThrow(() -> new RuntimeException("Disc not found: " + id)))	// throwing an exception if nothing is found
				.collect(Collectors.toList());

		// creating the 'Order' 
		Order order = new Order(person, discs, null);
		order.calculateTotalPrice();
		
		// saving the new 'Order'
		Order savedOrder = orderRepository.save(order);
		
		// and converting it to a DTO format
		return mapToDTO(savedOrder);
	}

	@Override
	public OrderDTO getOrderById(Long id) {
		return mapToDTO(orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found")));
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		return orderRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public List<OrderDTO> getOrdersByPerson(Long personId) {
		return orderRepository.findByPersonId(personId).stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public double calculateCashbackForOrder(Long orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
		
		// returning a 10% cashback
		return order.getTotalPrice().doubleValue() * 0.10;
	}
}