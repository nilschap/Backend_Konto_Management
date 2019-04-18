package com.example.bankaccountmanagement.Service;


import com.example.bankaccountmanagement.UserDomain.InputedUser;
import com.example.bankaccountmanagement.UserDomain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManagamentService implements ServiceInterface {

    private List<User> users = new ArrayList<>();
    private int newid;

    @Override
    public List listall() {
        return users;
    }

    @Override
    public void delete(int id) {
        users = users.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }

    public void register(InputedUser inputedUser) {
        newid++;
        User account = new User(newid, inputedUser.getUsername(), inputedUser.getPassword());
        users.add(account);
    }

    public boolean login(InputedUser user) {
        return users.stream()
                .anyMatch(e -> e.getUsername().equals(user.getUsername()) && e.getPassword().equals(user.getPassword()));
    }
}
