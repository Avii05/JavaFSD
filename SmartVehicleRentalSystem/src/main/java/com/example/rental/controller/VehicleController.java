package com.example.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.rental.entity.Vehicle;
import com.example.rental.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.addVehicle(vehicle);
	}
	
	@GetMapping("/{id}")
	public Vehicle getVehicle(@PathVariable Long id) {
		return vehicleService.getVehicle(id);
	}

}
