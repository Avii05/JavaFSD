package com.example.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rental.entity.Rental;
import com.example.rental.entity.Vehicle;
import com.example.rental.repository.RentalRepository;
import com.example.rental.repository.VehicleRepository;

@Service
public class RentalService {
	
	    @Autowired
	    private RentalRepository rentalRepository;

	    @Autowired
	    private VehicleRepository vehicleRepository;

	    public Rental createRental(Rental rental) {
	        Vehicle vehicle = vehicleRepository.findById(rental.getVehicleId()).orElse(null);
	        if (vehicle != null && vehicle.isAvailabilityStatus()) {
	            vehicle.setAvailabilityStatus(false);
	            vehicleRepository.save(vehicle);
	            return rentalRepository.save(rental);
	        }
	        return null;
	    }

	    public Rental returnVehicle(Long rentalId) {
	        Rental rental = rentalRepository.findById(rentalId).orElse(null);
	        if (rental != null) {
	            Vehicle vehicle = vehicleRepository.findById(rental.getVehicleId()).orElse(null);
	            if (vehicle != null) {
	                vehicle.setAvailabilityStatus(true);
	                vehicleRepository.save(vehicle);
	            }
	        }
	        return rental;
	    }

	    public Rental getRental(Long id) {
	        return rentalRepository.findById(id).orElse(null);
	    }
	}

