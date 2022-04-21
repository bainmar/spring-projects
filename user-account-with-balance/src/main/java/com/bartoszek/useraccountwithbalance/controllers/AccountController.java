package com.bartoszek.useraccountwithbalance.controllers;

import com.bartoszek.useraccountwithbalance.models.Account;
import com.bartoszek.useraccountwithbalance.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    ResponseEntity<List<Account>> getAllAccounts(){
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

}