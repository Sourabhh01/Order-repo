package com.order.req.services;
import java.util.List;

import com.order.req.entities.Order;

public interface OrderService {

	public List<Order> getOrders();

	public Order createOrder(Order order);

	public Order updateOrderById(Integer orderId, Order order);

	public void deleteOrderById(Integer orderId);

	public Order getOrder(Integer orderId);

}
