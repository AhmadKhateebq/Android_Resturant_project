package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.OrderItem;

import java.util.ArrayList;

public class OrderItemRes {
    public static ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>() {{
        add(new OrderItem(0, 0, 0, 1, 10));
        add(new OrderItem(1, 0, 2, 2, 20));
        add(new OrderItem(2, 0, 0, 1, 10));
        add(new OrderItem(3, 1, 0, 1, 10));
        add(new OrderItem(4, 1, 2, 2, 20));
        add(new OrderItem(5, 2, 0, 1, 10));
    }};
}
