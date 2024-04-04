package com.example.order.service;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.order.dto.OrderDto;
import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderrepo;
	private final ModelMapper modelMapper;

	@Autowired
	public OrderServiceImpl(OrderRepository orderrepo, ModelMapper modelMapper) {
		this.orderrepo = orderrepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<String> addtoOrder(OrderDto orderDto) {

		Order order = this.modelMapper.map(orderDto, Order.class);
		orderrepo.save(order);
		updateOrderStatus(order.getOrderId(), "Payment Success");
		return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Order Details saved\"}");

	}

	private void updateOrderStatus(Long orderId, String newStatus) {
		Order order = orderrepo.findById(orderId).orElse(null);
		if (order != null) {
			order.setStatus(newStatus);
			orderrepo.save(order);
		}
	}

	@Override
	public List<OrderDto> getAllOrders() {
		List<Order> orderlist = orderrepo.findAll();
		if (!(orderlist.isEmpty()))
			return orderlist.stream().map(order -> modelMapper.map(order, OrderDto.class)).toList();
		else
			return Collections.emptyList();

	}

	@Override
	public List<OrderDto> getOrderdetailsByEmail(String email) {
		List<Order> orders = orderrepo.findByEmail(email);
		if (!orders.isEmpty()) {
			return orders.stream().map(order -> modelMapper.map(order, OrderDto.class)).toList();
		} else {
			return Collections.emptyList();
		}
	}

}
