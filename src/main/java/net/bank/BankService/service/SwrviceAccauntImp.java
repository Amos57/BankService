package net.bank.BankService.service;

import net.bank.BankService.model.Account;
import net.bank.BankService.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SwrviceAccauntImp implements ServiceAccount{

	@Autowired
  AccountRepository acRepository;
	
	
	
	public Account addAccount(Account account) {
		return acRepository.save(account);
	}

	public Account addSum(Account account) {
		return acRepository.save(account);
	}

	public Account takeSum(Account account) {
		return acRepository.save(account);
	}

	
	public Account getAccount(int numberAccount) {
		return acRepository.findOne(numberAccount);
	}
}
