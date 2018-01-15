package PIM.WEBSERIVE.ACTIVITIE.STUDENT.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

	@Query(value = "SELECT * FROM `faculty` WHERE faculty_id = ?1", nativeQuery = true)
	public Faculty findByFacultyId(Integer facultyId);

	@Query(value = "SELECT * FROM `faculty` WHERE faculty_name = ?1", nativeQuery = true)
	public Faculty findByFacultyName(String facultyName);
	
}
