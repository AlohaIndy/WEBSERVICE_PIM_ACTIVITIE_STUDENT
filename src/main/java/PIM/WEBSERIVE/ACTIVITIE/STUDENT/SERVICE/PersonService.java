package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Person;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.REPOSITORY.PersonRepository;

@Service
@Transactional
public class PersonService {
	
	private PersonRepository personRepository;

	public PersonService(PersonRepository personDAO) {
		this.personRepository = personDAO;
	}

	public Person save(Person newPerson) {
		return personRepository.save(newPerson);
	}
	
	public Person findByPersonId(String personId) {
		return personRepository.findByPersonId(personId);
	}
	
	public List<Person> findByPersonIdGetList(String personId){
		return personRepository.findByPersonIdGetList(personId);
	}
	
}
