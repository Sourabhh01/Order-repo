package com.order.req;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class OrderReqApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderReqApplication.class, args);
	}
}
