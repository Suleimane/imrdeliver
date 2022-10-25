package com.imrdeliver.imrdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imrdeliver.imrdeliver.dto.OrderDTO;
import com.imrdeliver.imrdeliver.dto.ProductDTO;
import com.imrdeliver.imrdeliver.entities.Order;
import com.imrdeliver.imrdeliver.entities.OrderStatus;
import com.imrdeliver.imrdeliver.entities.Product;
import com.imrdeliver.imrdeliver.repositories.OrderRepository;
import com.imrdeliver.imrdeliver.repositories.ProductRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> orders = orderRepository.findOrdersWithProducts();
		return orders.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional 
	public OrderDTO save(OrderDTO orderDTO) {
		Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), 
				      orderDTO.getLongitude(), Instant.now(), OrderStatus.PENDENTE);
		for(ProductDTO productDTO : orderDTO.getProducts()) {
			Product product = productRepository.findById(productDTO.getId()).get();
			order.getProducts().add(product);
		}
		order = orderRepository.save(order);
		return new OrderDTO(order);
	}

}
