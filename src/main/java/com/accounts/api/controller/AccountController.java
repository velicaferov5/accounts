package com.accounts.api.controller;

import com.accounts.api.model.Account;
import com.accounts.api.service.AccountService;
import com.accounts.api.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-ful services to form Account, Customers and view them.
 */
@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

    private static AccountService accountService = new AccountService();
    private static TransactionService transactionService = new TransactionService();

    /**
     * Forms a new (current) account for customer {@param id} and sends a transaction to the new account
     * if {@param initialCredit} is not 0.
     *
     * @param customerId
     * @param initialCredit
     * @return new Account
     */
    @PostMapping(value = "/new/{customerId}/{initialCredit}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account newAccount (@PathVariable int customerId, @PathVariable double initialCredit) {
        return accountService.newAccount(customerId, initialCredit);
    }
}