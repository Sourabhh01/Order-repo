package com.order.req.repository;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.order.req.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
