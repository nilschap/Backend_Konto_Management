package com.example.bankaccountmanagement.Service;


import java.util.List;

public interface ServiceInterface<T> {
     List<T> listall();
     void delete(int id);
}
