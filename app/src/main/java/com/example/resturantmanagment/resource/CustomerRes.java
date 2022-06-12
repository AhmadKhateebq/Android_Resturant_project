package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.Customer;
import com.example.resturantmanagment.model.TempUser;

import java.util.ArrayList;

public class CustomerRes {
    static int id = 2;
    public static ArrayList<Customer> customers = new ArrayList<>() {{
        add(new Customer(0, "ahmad", "user", "user", "ahmadkhateebq@gmail.com", "123456"));
        add(new Customer(1, "ahmad2", "user1", "user1", "ahmadkhateeb2013@gmail.com", "012345"));
    }};

    public static boolean verify(TempUser user) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(user.getUsername()))
                if (customer.getPassword().equals(user.getPassword()))
                    return true;
        }
        return false;
    }

    public static Customer findByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username))
                return customer;
        }
        return null;
    }

    public static Customer findByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name))
                return customer;
        }
        return null;
    }

    public static Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id)
                return customer;
        }
        return null;
    }

    public static Customer addCustomer(Customer customer) {
        customer.setId(id++);
        customers.add(customer);
        return customer;
    }

    public static Customer addCustomer(String name, String username, String password, String email, String phone) {
        Customer customer = new Customer(
                id++,
                name,
                username,
                password,
                email,
                phone
        );
        customers.add(customer);
        return customer;
    }
}
