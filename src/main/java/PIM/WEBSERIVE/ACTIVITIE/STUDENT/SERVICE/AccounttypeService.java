package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Accounttype;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.REPOSITORY.AccounttypeRepository;

@Service
@Transactional
public class AccounttypeService {

	private AccounttypeRepository accounttypeRepository;

	public AccounttypeService(AccounttypeRepository accounttypeDAO) {
		this.accounttypeRepository = accounttypeDAO;
	}
	
	public Accounttype findByAccounttypeName(String accounttypeName) {
		return accounttypeRepository.findByAccounttypeName(accounttypeName);
	}
	
}
