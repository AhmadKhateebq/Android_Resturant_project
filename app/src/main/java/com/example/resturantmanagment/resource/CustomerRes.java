package com.example.resturantmanagment.resource;

import androidx.annotation.Nullable;

import com.example.resturantmanagment.model.Customer;
import com.example.resturantmanagment.model.TempUser;

import java.util.ArrayList;

public class CustomerRes {
    public static ArrayList<Customer> customers = new ArrayList<Customer>() {{
        add(new Customer(0, "ahmad","user","user", "ahmadkhateebq@gmail.com", "123456"));
        add(new Customer(1, "ahmad2","user1","user1", "ahmadkhateeb2013@gmail.com", "012345"));
    }};
    public static boolean verify(TempUser user){
        for (Customer customer : customers) {
            if (customer.getUsername().equals(user.getUsername()))
                if (customer.getPassword().equals(user.getPassword()))
                    return true;
        }
        return false;
    }
    @Nullable
    public static Customer findByUsername(String username){
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username))
                return customer;
        }
        return null;
    }
}
