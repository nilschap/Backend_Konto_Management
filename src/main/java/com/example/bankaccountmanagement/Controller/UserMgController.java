package com.example.bankaccountmanagement.Controller;

import com.example.bankaccountmanagement.AccountDomain.Account;
import com.example.bankaccountmanagement.Service.UserManagamentService;
import com.example.bankaccountmanagement.UserDomain.InputedUser;
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
public class UserMgController {

    @Autowired
    UserManagamentService userManagamentService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody InputedUser inputedUser) {

        if(userManagamentService.login(inputedUser)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else if(userManagamentService.login(inputedUser)==false) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody InputedUser inputedUser) {
        try {
            userManagamentService.register(inputedUser);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Account> listusers() {
        try {
            return userManagamentService.listall();
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteuser(@PathVariable("id") int id) {
        try {
            userManagamentService.delete(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
