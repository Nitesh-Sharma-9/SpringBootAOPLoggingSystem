package com.decimal.service.impl;

import com.decimal.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decimal.aop.aspect.Auditable;
import com.decimal.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Auditable(Auditable.GETLOGGER.FILESYSTEM)
	@Override
	public void addAccount(Account account) {
		accountRepository.save(account);
		System.out.println("Inside method: addAccount()");
	}
}
