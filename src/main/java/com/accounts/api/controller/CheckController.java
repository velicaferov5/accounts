package com.accounts.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CheckController {

    @RequestMapping("/")
    public String home() {
        return "Accounts API is working!";
    }
}
