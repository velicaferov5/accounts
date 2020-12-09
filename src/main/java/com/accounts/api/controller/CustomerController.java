package com.accounts.api.controller;

import com.accounts.api.model.Customer;
import com.accounts.api.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-ful services to for {@link Customer}.
 */
@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    private static AccountService accountService = new AccountService();

    /**
     * Gets Customer by {@param customerId}
     * @param customerId
     * @return Customer
     */
    @GetMapping(value = "/get/{customerId}")
    public Customer getCustomer (@PathVariable(name="customerId") int customerId) {
        return accountService.getCustomerById(customerId);
    }
}