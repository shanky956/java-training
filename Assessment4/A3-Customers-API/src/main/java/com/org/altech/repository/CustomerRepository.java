package com.org.altech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.org.altech.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}