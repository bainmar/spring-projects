package com.bartoszek.useraccountwithbalance.models;

import java.math.BigDecimal;

public class Account {
    private int id;
    private String name;
    private String surname;
    private BigDecimal amount;
    private String currency;

    public Account(String name, String surname, int id) {
        this.name=name;
        this.surname=surname;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBalance(BigDecimal amount, String currency) {
        this.amount=amount;
        this.currency=currency;
    }
}