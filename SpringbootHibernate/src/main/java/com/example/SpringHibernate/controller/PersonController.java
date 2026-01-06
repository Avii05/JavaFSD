/*Step 7: Create a REST Controller
Finally, we’ll expose the functionality through a REST API controller.*/
package com.example.SpringHibernate.controller;

import com.example.SpringHibernate.model.Person;
import com.example.SpringHibernate.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/people")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	//Create or update a person
	@PostMapping
	public Person createPerson(@RequestBody Person person){
		return personService.savePerson(person);
	}
	
	//Get all People
	@GetMapping
	public List<Person>getAllPeople(){
		return personService.getAllPeople();
	}
	
	//Get a person by ID
	@GetMapping("/{id}")
	public Optional<Person> getPersonById(@PathVariable Long id){
		return personService.getPersonById(id);
	}
	
	// Delete person by ID
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable long id) {
		personService.deletePerson(id);
	}

}
