package com.example.bankaccountmanagement.Service;


import com.example.bankaccountmanagement.AccountDomain.Account;
import com.example.bankaccountmanagement.AccountDomain.InputedAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountManagementService implements ServiceInterface {

    List<Account> accounts = new ArrayList<>();
    int newid = 0;

    @Override
    public List listall() {
        return accounts;
    }

    @Override
    public void delete(int id) {
        accounts = accounts.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }

    public Account getspecificaccount(int id) {
        return accounts.stream()
                .filter(e -> e.getId() == id)
                .findAny()
                .get();
    }

    public void newaccount(InputedAccount inputedAccount) {
        newid++;
        Account account = new Account(newid, inputedAccount.getName(), inputedAccount.getBalance(), inputedAccount.getIban());
        accounts.add(account);
    }

    public Account updateAccount(InputedAccount inputedAccount) {
        Account account = new Account(inputedAccount.getId(), inputedAccount.getName(), inputedAccount.getBalance(), inputedAccount.getIban());
        accounts = accounts.stream()
                .map(e -> e.getId() == inputedAccount.getId() ? account : e)
                .collect(Collectors.toList());
        return account;
    }
}
