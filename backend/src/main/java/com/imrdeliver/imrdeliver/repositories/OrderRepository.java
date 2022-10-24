package com.imrdeliver.imrdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imrdeliver.imrdeliver.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
