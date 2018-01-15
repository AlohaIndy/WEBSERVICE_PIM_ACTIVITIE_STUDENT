package PIM.WEBSERIVE.ACTIVITIE.STUDENT.CONTROLLER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
		facultyService.findAll();
		return majorService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "test")
	public Account test() {
		facultyService.findAll();
		String personId = "5852100103"; 
		String accounttypeName = "นักเรียน";
		String personGender = "ชาย";
		String personNameFirst = "นักเรียนดี";
		String personNameLast = "ทดสอบ";
		String personBirthdate = "21/02/2539 0:0:0";
		String majorName = "สาขาวิศวกรรมการผลิตยานยนต์";
		String accountUsername = "test103";
		String accountPassword = "test1";
		Major major = majorService.findByMajorName(majorName);
		Accounttype accounttype = accounttypeService.findByAccounttypeName(accounttypeName);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Date nowDate = Calendar.getInstance().getTime();
		try {
			date = dateFormat.parse(personBirthdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Person newPerson = personService
				.save(new Person(personId, major, personGender, personNameFirst, personNameLast, date, nowDate));
		Account newAccount = new Account(accounttype, newPerson, accountUsername, accountPassword, nowDate);
		System.out.println("finish");
		return accountService.save(newAccount);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Account PostRegister(@RequestBody Account account) {
		System.out.println("AccountRegister");
		facultyService.findAll();
		String personId = account.getPerson().getPersonId(); 
		String accounttypeName = account.getAccounttype().getAccounttypeName();
		String personGender = account.getPerson().getPersonGender();
		String personNameFirst = account.getPerson().getPersonNameFirst();
		String personNameLast = account.getPerson().getPersonNameLast();
		Date personBirthdate = account.getPerson().getPersonBirthdate();
		String majorName = account.getPerson().getMajor().getMajorName();
		String accountUsername = account.getAccountUsername();
		String accountPassword = account.getAccountPassword();
		Major major = majorService.findByMajorName(majorName);
		Accounttype accounttype = accounttypeService.findByAccounttypeName(accounttypeName);
		Date nowDate = Calendar.getInstance().getTime();
		Person newPerson = personService
				.save(new Person(personId, major, personGender, personNameFirst, personNameLast, personBirthdate, nowDate));
		Account newAccount = new Account(accounttype, newPerson, accountUsername, accountPassword, nowDate);
		System.out.println("finish");
		return accountService.save(newAccount);
	}

}
