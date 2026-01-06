/*Step 4.0: JPA entities are Java classes that map to database tables.
Let’s create a Person entity that will be stored in the person table.

*Step 4.1: Table Creation
*/

package com.example.SpringHibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //Marks this class as a JPA entity.
public class Person {
	
	@Id //Marks the id field as the primary key.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment the ID
    private Long id;
	
	private String name;
	private int age;
	
	// Default Constructor
	public Person() {
		
	}
	// Parameterized Constructor
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
    
	// Getters and Setters
	/* To Auto Generate Getter and Setter function
	   Right Click->Source->Generate Getters and Setters->SelectAll->Finish 
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
