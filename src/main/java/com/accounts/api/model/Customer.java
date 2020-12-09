package com.accounts.api.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private static Integer Id = 0;
	private Integer customerId;
	private String customerName;
	private String customerSurname;
	private List<Account> accountList;

	public Customer(Integer customerId, String customerName, String customerSurname) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.accountList = new ArrayList<>();
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId() {
		this.customerId = Id++;
	}

	public static int getLastCustomerId() {
		return Id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerFullname() {
		return (customerName + " " + customerSurname);
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
}
