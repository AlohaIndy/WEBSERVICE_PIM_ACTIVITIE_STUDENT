package PIM.WEBSERIVE.ACTIVITIE.STUDENT.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Query(value = "SELECT * FROM `account` WHERE account_username = ?1", nativeQuery = true)
	public List<Account> findByAccountIdGetList(String accountUsername);
	
}
