package com.example.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rental.entity.Customer;
import com.example.rental.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).orElse(null);
	}
}
