package com.example.bankaccountmanagement.AccountDomain;

public class InputedAccount {

    String name;
    double balance;
    String iban;

    public InputedAccount() {}

    public InputedAccount(String name, double balance, String iban) {
        this.name = name;
        this.balance = balance;
        this.iban = iban;
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
