package PIM.WEBSERIVE.ACTIVITIE.STUDENT.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Faculty;

public interface FacultyDAO extends JpaRepository<Faculty, Integer> {
	
}
