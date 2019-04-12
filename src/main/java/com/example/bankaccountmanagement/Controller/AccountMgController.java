package com.example.bankaccountmanagement.Controller;



import com.example.bankaccountmanagement.AccountDomain.Account;
import com.example.bankaccountmanagement.AccountDomain.InputedAccount;
import com.example.bankaccountmanagement.Service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountMgController {

    @Autowired
    AccountManagementService accountManagementService;

    @RequestMapping(value = "/api/accounts", method = RequestMethod.POST)
    public ResponseEntity newaccount(@RequestBody InputedAccount inputedAccount) {
        try {
            accountManagementService.newaccount(inputedAccount);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/api/accounts", method = RequestMethod.PUT)
    public Account updateAccount(@RequestBody InputedAccount inputedAccount) {
        try {
            return accountManagementService.updateAccount(inputedAccount);
        } catch(Exception e) {
            throw new NullPointerException();
        }
    }

    @RequestMapping(value = "/api/accounts", method = RequestMethod.GET)
    public List<Account> listaccounts() {
        try {
            return accountManagementService.listall();
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value="/api/accounts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteaccount(@PathVariable("id") int id) {
        try {
            accountManagementService.delete(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/api/accounts/{id}", method = RequestMethod.GET)
    public Account getspecificaccount(@PathVariable("id") int id) {
        try {
            return accountManagementService.getspecificaccount(id);
        }catch (Exception e) {
            throw new NullPointerException();
        }
    }

}
