package com.order.req.controllers;

import java.util.List;


import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.req.entities.Order;
import com.order.req.services.OrderServiceImpl;
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private OrderServiceImpl orderService;

	public OrderController(OrderServiceImpl orderService) {
		super();
		this.orderService = orderService;
	}
	//Read
	@GetMapping("/getAll")
	public List<Order> fetchOrders()
	{
		return orderService.getOrders();
	}
	//Read
	@GetMapping("/get/{id}")
	public Order fetchOrderById(@PathVariable Integer id)
	{
		return orderService.getOrder(id);
	}
	//Create
	@PostMapping("/create")
	public Order createOrder(@Valid @RequestBody Order order)
	{
		return orderService.createOrder(order);
	}
	//Update
	@PutMapping("/update/{id}")
	public Order updateOrderById(@PathVariable Integer id, @RequestBody Order order)
	{
		return orderService.updateOrderById(id, order);
	}
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable Integer id)
	{
		orderService.deleteOrderById(id);
		return new ResponseEntity<String>("record deleted",HttpStatus.OK);
	}
}
