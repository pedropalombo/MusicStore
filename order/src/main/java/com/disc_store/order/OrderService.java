package com.disc_store.order;

import java.util.List;

// instancing the methods to be used by 'Order'
public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(Long id);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByPerson(Long personId);

    void deleteOrder(Long id);

    double calculateCashbackForOrder(Long orderId);
}