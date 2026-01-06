package com.example.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.rental.entity.Rental;
import com.example.rental.service.RentalService;

@RestController
@RequestMapping
public class RentalController {
	
	@Autowired
	private RentalService rentalService;
	
	@PostMapping
	public Rental createRental(@RequestBody Rental rental) {
		return rentalService.createRental(rental);
	}
	
	@PutMapping("/{id}/return")
	public Rental returnVehicle(@PathVariable Long id) {
		return rentalService.returnVehicle(id);
	}
	
	@GetMapping("/{id")
	public Rental getRental(@PathVariable Long id) {
		return rentalService.getRental(id);
		}

}
