package com.bartoszek.useraccountwithbalance.controllers;

import com.bartoszek.useraccountwithbalance.models.Account;
import com.bartoszek.useraccountwithbalance.services.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private AccountService accountService;

    @Test
    void getAllAccounts() throws Exception {

        var mapper = new ObjectMapper();
        List<Account> accountsList = new ArrayList<>();

        Account accountOne= new Account("Marcin","B",1);
        accountOne.setBalance(new BigDecimal(1000),"złoty");

        Account accountTwo = new Account("Michal", "B",2);
        accountTwo.setBalance(new BigDecimal(2000),"złoty");

        accountsList.add(accountOne);
        accountsList.add(accountTwo);

        var expected = mapper.writeValueAsString(accountsList);

        when(accountService.findAll()).thenReturn(accountsList);

        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }
}