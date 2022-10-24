package com.imrdeliver.imrdeliver.services;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imrdeliver.imrdeliver.ProductDTO;
import com.imrdeliver.imrdeliver.entities.Product;
import com.imrdeliver.imrdeliver.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> products = productRepository.findAllByOrderByNameASC();
		return products.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

}
