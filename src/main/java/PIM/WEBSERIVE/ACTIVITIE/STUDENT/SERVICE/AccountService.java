package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.DAO.AccountDAO;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Account;

@Service
@Transactional
public class AccountService {
	
	private AccountDAO accountDAO;

	public AccountService(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public Account save(Account newAccount) {
		return accountDAO.save(newAccount);
	}
	
}
