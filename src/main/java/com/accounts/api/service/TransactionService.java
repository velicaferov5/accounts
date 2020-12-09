package com.accounts.api.service;

import com.accounts.api.model.Account;

public class TransactionService {

	public void addTransactions(Account account, String desc) {
		account.transactions.add(desc);
	}

}
