/*Step 6: The service layer is where you’ll write your business 
logic, and it will use the repository to interact with the 
database.
 */
package com.example.SpringHibernate.service;

import com.example.SpringHibernate.model.Person;
import com.example.SpringHibernate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) { // Create or Update a Person
		return personRepository.save(person);
	}
	
	public List<Person> getAllPeople(){ // Get All People
		return personRepository.findAll();
	}
	
	public Optional<Person> getPersonById(Long id){// Get person by ID
		return personRepository.findById(id);
	}
	
	public void deletePerson(long id) {// Delete person by ID
		personRepository.deleteById(id);
	}

}
