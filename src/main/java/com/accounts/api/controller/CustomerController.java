package com.accounts.api.controller;

import com.accounts.api.model.Customer;
import com.accounts.api.service.AccountService;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Removes customer
     *
     * @param customerId
     * @return result of remove
     */
    @DeleteMapping(value = "/remove/{customerId}")
    public boolean removeCustomer (@PathVariable(name="customerId") int customerId) {
        return accountService.removeCustomerById(customerId);
    }
}