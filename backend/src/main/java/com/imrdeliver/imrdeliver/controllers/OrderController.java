package com.imrdeliver.imrdeliver.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imrdeliver.imrdeliver.dto.OrderDTO;
import com.imrdeliver.imrdeliver.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
		List<OrderDTO> orders = orderService.findAll();
		return ResponseEntity.ok().body(orders);
	}
	
	@PostMapping
	public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO){
		orderDTO = orderService.save(orderDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(orderDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(orderDTO);
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDTO> update(@PathVariable("id") Long id){
		OrderDTO orderDTO = orderService.setDelivered(id);
		return ResponseEntity.ok().body(orderDTO);
	}

}
