package com.bartoszek.useraccountwithbalance;

import com.bartoszek.useraccountwithbalance.models.Account;
import com.bartoszek.useraccountwithbalance.repositiories.AccountRepository;
import com.bartoszek.useraccountwithbalance.services.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @DisplayName("It is possible to create user account with given personal data, currency type and balance")
    @Test
    void createAccountWithGivenData(){

        Account user = new Account("jan","kowalski",1);
        user.setBalance(new BigDecimal(3000),"zloty");
        accountService.createAccount(user);

        verify(accountRepository).saveAccount(user);

    }

}