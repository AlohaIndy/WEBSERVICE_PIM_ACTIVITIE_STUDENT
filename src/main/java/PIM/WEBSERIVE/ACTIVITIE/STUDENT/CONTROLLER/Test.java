package PIM.WEBSERIVE.ACTIVITIE.STUDENT.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Faculty;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Major;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.AccountService;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.AccounttypeService;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.FacultyService;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.MajorSerivice;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.PersonService;

@RestController
@CrossOrigin
@RequestMapping(path = "test")
public class Test {
	
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
	public Major GetTest() {
		
		facultyService.findAll();

		String majorName = "สาขาวิศวกรรมการผลิตยานยนต์";

		Major major = majorService.findByMajorName(majorName);
		
		System.out.println("faculty : "+major.getFaculty().getFacultyId());
		
		return major;
	}

}
