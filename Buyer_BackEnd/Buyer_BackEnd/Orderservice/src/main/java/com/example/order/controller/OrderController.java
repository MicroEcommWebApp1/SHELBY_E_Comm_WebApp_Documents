package com.example.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.dto.OrderDto;
import com.example.order.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {
	private final OrderService orderservice;

	@Autowired
	public OrderController(OrderService orderservice) {
		this.orderservice = orderservice;

	}

	@PostMapping("/createorder")
	public ResponseEntity<String> addOrder(@RequestBody OrderDto orderDto) {
		return orderservice.addtoOrder(orderDto);
	}

	@GetMapping("/orderdetails")
	public List<OrderDto> getAllOrderslist() {
		return orderservice.getAllOrders();
	}

	@GetMapping("/orderdetails/{email}")
	public List<OrderDto> getOrderdetailsByEmaillist(@PathVariable String email) {
		return orderservice.getOrderdetailsByEmail(email);
	}
	@GetMapping("/sellerorderdetails/{sellerEmailID}")
	public List<OrderDto> getOrderdetailsBySellerEmailID(@PathVariable String sellerEmailID) {
		return orderservice.getOrderdetailsBySellerEmailID(sellerEmailID);
	}
}
