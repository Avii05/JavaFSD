
package com.example.SmartEventManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartEventManagement.entity.Attendee;
import com.example.SmartEventManagement.repository.AttendeeRepository;

@Service
public class AttendeeService {

	@Autowired 
    private final AttendeeRepository repo;/*defines a private final field called repo of type AttendeeRepository. 
	AttendeeRepository is presumably an interface that extends one of Spring Data's 
	repository interface*/

	
    public AttendeeService(AttendeeRepository repo) {/*Autowired tells Spring to inject an instance
    of AttendeeRepository into the constructor of the AttendeeService class and it is assigned to the repo field.*/
        this.repo = repo;
    }

    // public method that registers an Attendee
    public Attendee register(Attendee a) {/*akes an Attendee object as a parameter and
     returns an Attendee object. The method name, register, suggests 
     that it will create a new attendee (likely saving it to a database).*/
        
    	return repo.save(a); //to save the Attendee object a to the database
    }

    //a public method that retrieves an Attendee by its ID
    public Attendee get(Long id) {
        return repo.findById(id).orElse(null);
    }
}

