package com.order.req.entities;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_details")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seqNo;
	private Long productId;
	private Long quantity;
	private String createdUser;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private Order order;//manage Foreign Key
}
