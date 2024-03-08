package com.org.altech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.altech.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	List<Order> findByCustomerId(int customer_id);

}
