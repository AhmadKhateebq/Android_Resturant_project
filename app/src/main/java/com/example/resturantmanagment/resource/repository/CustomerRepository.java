package com.example.resturantmanagment.resource.repository;

import com.example.resturantmanagment.model.Customer;
import com.example.resturantmanagment.model.TempUser;

public interface CustomerRepository {

    boolean verify(TempUser user);

    Customer findByUsername(String username);

    Customer findByName(String name);

    Customer findById(int id);

    Customer addCustomer(Customer customer);

    Customer addCustomer(String name, String username, String password, String email, String phone);
}
