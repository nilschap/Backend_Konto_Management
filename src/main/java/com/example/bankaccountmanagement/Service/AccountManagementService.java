package com.example.bankaccountmanagement.Service;


import com.example.bankaccountmanagement.AccountDomain.Account;
import com.example.bankaccountmanagement.AccountDomain.InputedAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountManagementService implements ServiceInterface {

    List<Account> accounts=new ArrayList<>();
    int newid=0;

    @Override
    public List listall() {
        return accounts;
    }

    @Override
    public void delete(int id) {
        for(int i=0; i<accounts.size();i++) {
            if(accounts.get(i).getId()==id) {
                accounts.remove(i);
            }
        }
    }

    public Account getspecificaccount(int id) {
        return accounts.get(id);
    }

    public void newaccount(InputedAccount inputedAccount) {
        newid++;
        Account account=new Account(newid,inputedAccount.getName(), inputedAccount.getBalance(),inputedAccount.getIban());
        accounts.add(account);
    }
}
