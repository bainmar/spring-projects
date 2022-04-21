package com.bartoszek.useraccountwithbalance.services;

import com.bartoszek.useraccountwithbalance.models.Account;
import com.bartoszek.useraccountwithbalance.repositiories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public  void createAccount(Account user) {
        accountRepository.saveAccount(user);
    }

    public List<Account> findAll() {
        return List.of();
    }
}