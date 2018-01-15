package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.ENTITY.Account;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.REPOSITORY.AccountRepository;

@Service
@Transactional
public class AccountService {
	
	private AccountRepository accountRepository;

	public AccountService(AccountRepository accountDAO) {
		this.accountRepository = accountDAO;
	}

	public Account save(Account newAccount) {
		return accountRepository.save(newAccount);
	}
	
	public List<Account> findByAccountIdGetList(String accountUsername){
		return accountRepository.findByAccountIdGetList(accountUsername);
	}
	
}
