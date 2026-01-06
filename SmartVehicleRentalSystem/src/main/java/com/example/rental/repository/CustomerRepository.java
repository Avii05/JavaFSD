package com.example.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rental.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	

}
