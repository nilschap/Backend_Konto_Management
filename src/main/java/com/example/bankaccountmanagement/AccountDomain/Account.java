package com.example.bankaccountmanagement.AccountDomain;

public class Account {

    int id;
    String name;
    double balance;
    String iban;

    public Account(int id,String name, double balance, String iban) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.iban = iban;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
