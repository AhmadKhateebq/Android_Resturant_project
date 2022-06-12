package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.Employee;
import com.example.resturantmanagment.model.TempUser;
import com.example.resturantmanagment.model.enums.ROLE;

import java.util.ArrayList;

public class EmployeeRes {
    public static ArrayList<Employee> employees = new ArrayList<>() {{
        add(new Employee(0, "admin", "admin", "admin", "aa@a.a", "0", ROLE.MANAGER));
        add(new Employee(1, "service", "user", "user", "aa@a.a", "0", ROLE.SERVICE));
        add(new Employee(2, "chef", "chef", "chef", "aa@a.a", "0", ROLE.CHEF));
        add(new Employee(3, "del", "del", "del", "aa@a.a", "0", ROLE.DELIVERY));
    }};

    public static boolean verify(TempUser user) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(user.getUsername()))
                if (employee.getPassword().equals(user.getPassword()))
                    return true;
        }
        return false;
    }
}
