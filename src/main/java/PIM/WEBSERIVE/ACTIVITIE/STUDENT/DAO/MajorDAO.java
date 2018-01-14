package PIM.WEBSERIVE.ACTIVITIE.STUDENT.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Major;

public interface MajorDAO extends JpaRepository<Major, Integer>{
	
	@Query(value = "SELECT * FROM `major` WHERE major_name = ?1", nativeQuery = true)
	public Major findByMajorName(String majorName);

}
