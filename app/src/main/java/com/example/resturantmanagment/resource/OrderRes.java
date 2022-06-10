package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.Order;

import java.util.ArrayList;

public class OrderRes {
    public static ArrayList<Order> orders = new ArrayList<Order>() {{
        add(new Order(0, 0, "waiting"));
        add(new Order(1, 0, "done"));
        add(new Order(2, 1, "waiting"));
    }};
}
