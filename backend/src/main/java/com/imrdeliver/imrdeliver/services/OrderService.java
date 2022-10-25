package com.imrdeliver.imrdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imrdeliver.imrdeliver.dto.OrderDTO;
import com.imrdeliver.imrdeliver.entities.Order;
import com.imrdeliver.imrdeliver.repositories.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> orders = orderRepository.findOrdersWithProducts();
		return orders.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

}
