package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.Employee;

import java.util.ArrayList;

public class EmployeeRes {
    public static ArrayList<Employee> employees = new ArrayList<Employee>() {{
        add(new Employee(0, "admin", "admin", "admin", "aa@a.a", "0", "manager"));
        add(new Employee(1, "service", "user", "user", "aa@a.a", "0", "service"));
        add(new Employee(2, "chef", "chef", "chef", "aa@a.a", "0", "chef"));
    }};
}
