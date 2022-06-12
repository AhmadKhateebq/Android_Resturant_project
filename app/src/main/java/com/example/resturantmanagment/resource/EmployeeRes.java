package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.Employee;
import com.example.resturantmanagment.model.enums.ROLE;

import java.util.ArrayList;

public class EmployeeRes {
    public static ArrayList<Employee> employees = new ArrayList<Employee>() {{
        add(new Employee(0, "admin", "admin", "admin", "aa@a.a", "0", ROLE.MANAGER));
        add(new Employee(1, "service", "user", "user", "aa@a.a", "0", ROLE.SERVICE));
        add(new Employee(2, "chef", "chef", "chef", "aa@a.a", "0", ROLE.CHEF));
        add(new Employee(3, "del", "del", "del", "aa@a.a", "0", ROLE.DELIVERY));
    }};
}
