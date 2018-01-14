package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.DAO.FacultyDAO;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Faculty;

@Service
@Transactional
public class FacultyService {
	
	private FacultyDAO facultyDAO;

	public FacultyService(FacultyDAO facultyDAO) {
		this.facultyDAO = facultyDAO;
	}

	public Iterable<Faculty> findAll() {
		return facultyDAO.findAll();
	}
	
}
