package com.accounts.api.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private Integer accountId;
	private double balance;
	public List<String> transactions = new ArrayList<>();

	public Account(Integer accountId, double balance) {
		this.accountId = accountId;
		this.balance = balance;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public List<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<String> transactions) {
		this.transactions = transactions;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", transactions=" + transactions + "]";
	}

}
