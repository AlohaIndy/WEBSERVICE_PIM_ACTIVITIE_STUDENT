package PIM.WEBSERIVE.ACTIVITIE.STUDENT.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Query(value = "SELECT * FROM `person` WHERE person_id = ?1", nativeQuery = true)
	public Person findByPersonId(String personId);
	
	@Query(value = "SELECT * FROM `person` WHERE person_id = ?1", nativeQuery = true)
	public List<Person> findByPersonIdGetList(String personId);
	
}
