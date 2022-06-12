package com.example.resturantmanagment.resource.repository;

import com.example.resturantmanagment.model.Order;
import com.example.resturantmanagment.model.TempUser;

public interface EmployeeRepository {
    static EmployeeRepository getInstance() {
        return null;
    }
    boolean verify(TempUser user);

}
