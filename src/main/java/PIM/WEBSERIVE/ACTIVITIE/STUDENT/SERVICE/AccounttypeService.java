package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.DAO.AccounttypeDAO;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Accounttype;

@Service
@Transactional
public class AccounttypeService {

	private AccounttypeDAO accounttypeDAO;

	public AccounttypeService(AccounttypeDAO accounttypeDAO) {
		this.accounttypeDAO = accounttypeDAO;
	}
	
	public Accounttype findByAccounttypeName(String accounttypeName) {
		return accounttypeDAO.findByAccounttypeName(accounttypeName);
	}
	
}
