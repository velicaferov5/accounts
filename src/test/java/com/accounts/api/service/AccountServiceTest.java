package com.accounts.api.service;

import com.accounts.api.model.Account;
import com.accounts.api.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    private static final int CUSTOMERS = 5;

    @Test
    void testNewAccountWithoutAmount() {
        removeCustomers();
        Account account = new Account(Customer.getLastCustomerId(), 0);
        assertAccounts(account, accountService.newAccount(Customer.getLastCustomerId()+1, 0));
    }

    @Test
    void testNewAccountWithDeposit() {
        removeCustomers();
        Account account = new Account(Customer.getLastCustomerId(), 25);
        account.getTransactions().add("01-12-2020 00:00:00 + Depositted: " + 25);
        assertAccounts(account, accountService.newAccount(Customer.getLastCustomerId()+1, 25));
    }

    @Test
    void testNewAccountWithWithdrawal() {
        removeCustomers();
        Account account = new Account(Customer.getLastCustomerId(), -25);
        account.getTransactions().add("01-12-2020 00:00:00 + Withdrawed: " + 25);
        assertAccounts(account, accountService.newAccount(Customer.getLastCustomerId()+1, -25));
    }

    private void removeCustomers() {
        for (int index=0; index<CUSTOMERS; index++) {
            accountService.removeCustomerById(index);
        }
    }

    private void assertAccounts(Account expected, Account actual) {
        assertTrue((expected == null && actual == null) || (expected != null && actual != null) );
        assertEquals(expected.getAccountId(), actual.getAccountId());
        assertEquals(expected.getBalance(), actual.getBalance());
        assertTransactions(expected.getTransactions(), actual.getTransactions());
    }

    private void assertTransactions(List<String> expected, List<String> actual) {
        removeCustomers();
        assertEquals(expected.size(), actual.size());
    }
}