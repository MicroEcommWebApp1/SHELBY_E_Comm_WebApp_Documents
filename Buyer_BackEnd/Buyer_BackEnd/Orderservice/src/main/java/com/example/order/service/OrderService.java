package com.example.order.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.order.dto.OrderDto;

public interface OrderService {

	ResponseEntity<String> addtoOrder(OrderDto orderDto);

	List<OrderDto> getAllOrders();

	List<OrderDto> getOrderdetailsByEmail(String email);

}
