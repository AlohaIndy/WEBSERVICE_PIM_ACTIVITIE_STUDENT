package PIM.WEBSERIVE.ACTIVITIE.STUDENT.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Accounttype;

public interface AccounttypeRepository extends JpaRepository<Accounttype, Integer>{

	@Query(value = "SELECT * FROM `accounttype` WHERE accounttype_name = ?1", nativeQuery = true)
	public Accounttype findByAccounttypeName(String accounttypeName);
	
}
