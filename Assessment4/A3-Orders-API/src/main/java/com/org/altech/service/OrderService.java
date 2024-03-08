package com.org.altech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.altech.entity.Order;
import com.org.altech.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                              .orElse(null);
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public Order createOrder(Order order) {
        // Perform any additional business logic/validation here
        
        // Save the order to the database
        return orderRepository.save(order);
    }

    public Order updateOrder(int orderId, Order updatedOrder) {
        // Check if the order exists
        if (!orderRepository.existsById(orderId)) {
            return null; // Order with given ID not found
        }
        
        // Update the order details
        updatedOrder.setOrder_id(orderId); // Ensure the ID is set correctly
        return orderRepository.save(updatedOrder);
    }

    public boolean deleteOrder(int orderId) {
        // Check if the order exists
        if (!orderRepository.existsById(orderId)) {
            return false; // Order with given ID not found
        }
        
        // Delete the order from the database
        orderRepository.deleteById(orderId);
        return true;
    }
}
