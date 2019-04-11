package com.example.bankaccountmanagement.Service;


import com.example.bankaccountmanagement.UserDomain.InputedUser;
import com.example.bankaccountmanagement.UserDomain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagamentService implements ServiceInterface {

    List<User> users=new ArrayList<>();
    int newid;

    @Override
    public List listall() {
       return users;
    }

    @Override
    public void delete(int id) {
        for(int i=0; i<users.size();i++) {
            if(users.get(i).getId()==id) {
                users.remove(i);
            }
        }
    }

    public void register(InputedUser inputedUser) {
        newid++;
        User account=new User(newid,inputedUser.getUsername(), inputedUser.getPassword());
        users.add(account);
    }

    public boolean login(InputedUser user) {

        for (int i = 0; i < users.size(); i++) {
            String username = users.get(i).getUsername();
            String password = users.get(i).getPassword();
            if (username == user.getUsername() && password == user.getPassword()) {
                return true;
            }
        }
        return false;
    }
}
