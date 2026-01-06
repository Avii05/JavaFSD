package com.example.rental.entity;

import jakarta.persistence.*;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long VehicleId;
	
	@Column(name="model")
	private String model;
	
	@Column(name="type")
	private String type;
	
	@Column(name="availabilityStatus")
	private boolean availabilityStatus;
	
    // Getters and Setters
	public Long getVehicleId() {
		return VehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		VehicleId = vehicleId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
}
