package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Faculty;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.REPOSITORY.FacultyRepository;

@Service
@Transactional
public class FacultyService {
	
	private FacultyRepository facultyRepository;

	public FacultyService(FacultyRepository facultyDAO) {
		this.facultyRepository = facultyDAO;
	}

	public Iterable<Faculty> findAll() {
		return facultyRepository.findAll();
	}
	
	public Faculty findByFacultyId(Integer facultyId) {
		return facultyRepository.findByFacultyId(facultyId);
	}
	
	public Faculty findByFacultyName(String facultyName) {
		return facultyRepository.findByFacultyName(facultyName);
	}
	
}
