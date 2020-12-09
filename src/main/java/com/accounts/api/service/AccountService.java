package com.accounts.api.service;

import com.accounts.api.model.Account;
import com.accounts.api.model.Customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class AccountService {

    private static Map<Integer, Customer> customerMap = new HashMap<>();
    private static List<Account> accountList = new ArrayList<>();
    private static TransactionService transactionService = new TransactionService();


    public static Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    public static List<Account> getAccountList() {
        return accountList;
    }

    public static TransactionService getTransactionService() {
        return transactionService;
    }

    /**
     * Forms a new (current) account for customer {@param id} and sends a transaction to the new account
     * if {@param initialCredit} is not 0.
     *
     * @param customerId
     * @param initialCredit
     * @return new Account
     */
    public Account newAccount(int customerId, double initialCredit) {
        Optional<Customer> optional =  Optional.ofNullable(customerMap.get(customerId));
        Customer customer = optional.orElseGet(() -> newCustomer(customerId));
        int accountId = customer.getAccountList().size();
        Account account = new Account(accountId, 0);
        depositOrWithdraw(account, initialCredit);
        customer.getAccountList().add(account);
        customerMap.put(customerId, customer);
        return account;
    }

    public Account getAccountById(Integer accountId) {
        List<Account> accountList = getAccountList();
        Optional<Account> optional = accountList.stream().filter(a -> a.getAccountId().equals(accountId)).findAny();
        return optional.orElse(null);
    }

    private boolean deposit(Account account, double amount) {
        if (amount > 0) {
            LocalDate today = LocalDate.now();
            LocalTime time = LocalTime.now();
            account.setBalance(account.getBalance() + amount);
            getTransactionService().addTransactions(account, today + " " + time + " Depositted: " + amount);
            return true;
        }
        return false;
    }

    private boolean withdraw(Account account, double amount) {
        if (amount < 0) {
            LocalDate today = LocalDate.now();
            LocalTime time = LocalTime.now();
            account.setBalance(account.getBalance() + amount);
            getTransactionService().addTransactions(account, today + " " + time + " Withdrawed: " + amount);
            return true;
        }
        return false;
    }

    private boolean depositOrWithdraw(Account account, double amount) {
        if (amount > 0) {
            return deposit(account, amount);
        } else if (amount < 0) {
            return withdraw(account, amount);
        }
        return false;
    }

    public Customer getCustomerById(Integer customerId) {
        return customerMap.get(customerId);
    }

    private Customer newCustomer(int customerId) {
        return new Customer(customerId, "unknown", "unknown");
    }
}
