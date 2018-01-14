package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.DAO.PersonDAO;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Person;

@Service
@Transactional
public class PersonService {
	
	private PersonDAO personDAO;

	public PersonService(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public Person save(Person newPerson) {
		return personDAO.save(newPerson);
	}
	
	
	
}
