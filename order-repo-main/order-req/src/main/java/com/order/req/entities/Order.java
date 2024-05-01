package com.order.req.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;

	private int customerId;

	private int orderValue;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
	private Date deliveryDate;

	@NotEmpty(message = "User is mandatory !")
	@Size(min = 3, message = "User must be atleast 3 characters !")
	private String createdUser;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
	private Date createdDate;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<OrderDetails> orderDetails = new ArrayList<>();//manage relationship

}
