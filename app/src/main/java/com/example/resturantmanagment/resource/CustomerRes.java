package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.Customer;
import com.example.resturantmanagment.model.TempUser;
import com.example.resturantmanagment.resource.repository.CustomerRepository;

import java.util.ArrayList;

public class CustomerRes implements CustomerRepository {
    private static CustomerRes INSTANCE;
    static int id = 2;
    public static ArrayList<Customer> customers = new ArrayList<>() {{
        add(new Customer(0, "ahmad", "user", "user", "ahmadkhateebq@gmail.com", "123456"));
        add(new Customer(1, "ahmad2", "user1", "user1", "ahmadkhateeb2013@gmail.com", "012345"));
    }};

    public static CustomerRes getInstance() {
        if (INSTANCE == null){
            synchronized (CustomerRes.class){
                if (INSTANCE == null){
                    INSTANCE = new CustomerRes();
                }
            }
        }
        return INSTANCE;
    }

    public boolean verify(TempUser user) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(user.getUsername()))
                if (customer.getPassword().equals(user.getPassword()))
                    return true;
        }
        return false;
    }

    public Customer findByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username))
                return customer;
        }
        return null;
    }

    public Customer findByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name))
                return customer;
        }
        return null;
    }

    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id)
                return customer;
        }
        return null;
    }

    public Customer addCustomer(Customer customer) {
        customer.setId(id++);
        customers.add(customer);
        return customer;
    }

    public Customer addCustomer(String name, String username, String password, String email, String phone) {
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
