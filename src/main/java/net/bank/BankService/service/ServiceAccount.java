package net.bank.BankService.service;

import net.bank.BankService.model.Account;


public interface ServiceAccount {

	Account addAccount(Account account);
	
	Account addSum(Account account);
	
	Account takeSum(Account account);
	
	Account getAccount(int numberAccount);
	
	
}
