/*Step 5: Spring Data JPA allows you to interact with the database without
writing SQL queries. It provides a repository interface for 
performing CRUD operations.*/

package com.example.SpringHibernate.repository;

import com.example.SpringHibernate.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
  /*Person is your entity class (likely a JPA entity).

    Long is the type of the ID field for the Person entity (the 
    primary key). This allows Spring Data JPA to handle all basic
     operations for Person objects with Long-type IDs.
  */
}
 
/*JpaRepository is a Spring Data JPA Interface provides generic 
CRUD (Create, Read, Update, Delete) operations for the entity 
type you specify.Comes with a lot of built-in methods like:
save(S entity) - save a Person,
findById(ID id) - Find a person by their ID, 
findAll() - Get all person,
deleteById(ID id) - Delete a person by their ID.

Find by field: If you wanted to find a Person by their name,
you could add a method like this:

List<Person> findByName(String name);

Spring Data JPA will automatically generate the SQL query based 
on the method name (findByName). This will be equivalent to the 
following SQL query:

SELECT * FROM person WHERE name = ?;
*/