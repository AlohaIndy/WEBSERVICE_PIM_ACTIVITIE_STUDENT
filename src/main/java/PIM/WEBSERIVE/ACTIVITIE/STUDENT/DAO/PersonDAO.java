package PIM.WEBSERIVE.ACTIVITIE.STUDENT.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Person;

public interface PersonDAO extends JpaRepository<Person, Integer>{

}
