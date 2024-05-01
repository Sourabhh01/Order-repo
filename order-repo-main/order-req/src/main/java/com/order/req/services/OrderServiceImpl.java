package com.order.req.services;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.req.entities.Order;
import com.order.req.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepo;

	public OrderServiceImpl(OrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	@Override
	public List<Order> getOrders()
	{
		return orderRepo.findAll();
	}

	@Override
	@Transactional
	public Order createOrder(Order order)
	{
		return orderRepo.save(order);
	}

	@Override
	@Transactional
	public Order updateOrderById(Integer orderId, Order order)
	{
		Order existingOrder = orderRepo.findById(orderId)
				.orElseThrow(() -> new RuntimeException("Order not found"));
		existingOrder.setCreatedUser(order.getCreatedUser());
		return orderRepo.save(existingOrder);
	}

	public Order getOrder(Integer orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

	@Override
	public void deleteOrderById(Integer orderId)
	{
		Order thisOrder = orderRepo.findById(orderId)
				.orElseThrow(() -> new RuntimeException("Order not found"));
		orderRepo.delete(thisOrder);
	}
}
