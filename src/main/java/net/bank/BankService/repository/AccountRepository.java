package net.bank.BankService.repository;

import net.bank.BankService.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
