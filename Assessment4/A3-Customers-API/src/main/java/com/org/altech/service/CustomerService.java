package com.org.altech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.altech.entity.Customer;
import com.org.altech.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int customer_id) {
        return customerRepository.findById(customer_id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int customer_id, Customer customer) {
        if (!customerRepository.existsById(customer_id)) {
            return null;
        }
        customer.setCustomer_id(customer_id);
        return customerRepository.save(customer);
    }

    public boolean deleteCustomer(int customer_id) {
        if (!customerRepository.existsById(customer_id)) {
            return false;
        }
        customerRepository.deleteById(customer_id);
        return true;
    }
}
