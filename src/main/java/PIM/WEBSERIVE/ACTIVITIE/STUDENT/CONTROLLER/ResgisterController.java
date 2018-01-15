package PIM.WEBSERIVE.ACTIVITIE.STUDENT.CONTROLLER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Account;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Accounttype;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Major;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Person;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.AccountService;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.AccounttypeService;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.FacultyService;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.MajorSerivice;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.PersonService;

@RestController
@CrossOrigin
@RequestMapping(path = "register")
public class ResgisterController {

	@Autowired
	FacultyService facultyService;
	@Autowired
	MajorSerivice majorService;
	@Autowired
	AccountService accountService;
	@Autowired
	AccounttypeService accounttypeService;
	@Autowired
	PersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Major> GetRegister() {
		System.out.println("GetRegister");
		facultyService.findAll();
		System.out.println("GetRegister=finish");
		return majorService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Account> PostRegister(@RequestBody Account account) {
		String personId = account.getPerson().getPersonId(); 
		String accounttypeName = "นักเรียน";
		String personGender = account.getPerson().getPersonGender();
		String personNameFirst = account.getPerson().getPersonNameFirst();
		String personNameLast = account.getPerson().getPersonNameLast();
		Date personBirthdate = account.getPerson().getPersonBirthdate();
		String majorName = account.getPerson().getMajor().getMajorName();
		String accountUsername = account.getAccountUsername();
		String accountPassword = account.getAccountPassword();
		Date nowDate = Calendar.getInstance().getTime();
		System.out.println("AccountRegister"+personId);
		List<Person> checkPersons=personService.findByPersonIdGetList(personId);
		if (checkPersons.isEmpty()) {
			facultyService.findAll();
			Major major = majorService.findByMajorName(majorName);
			Accounttype accounttype = accounttypeService.findByAccounttypeName(accounttypeName);
			Person newPerson = personService
					.save(new Person(personId, major, personGender, personNameFirst, personNameLast, personBirthdate, nowDate));
			Account newAccount = new Account(accounttype, newPerson, accountUsername, accountPassword, nowDate);
			return new ResponseEntity<Account>(accountService.save(newAccount),HttpStatus.OK);	
		}
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

}
