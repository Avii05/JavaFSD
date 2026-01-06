package com.example.rental.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Rental {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rentalId;
	
	@Column(name="VehicleId")
	private Long VehicleId;
	
	@Column(name="startDate")
	private LocalDate startDate;
	
	@Column(name="endDate")
	private LocalDate endDate;
	
    // Getters and Setters
	public Long getRentalId() {
		return rentalId;
	}

	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
	}

	public Long getVehicleId() {
		return VehicleId;
	}

	public void setCustomerId(Long VehicleId) {
		this.VehicleId = VehicleId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
