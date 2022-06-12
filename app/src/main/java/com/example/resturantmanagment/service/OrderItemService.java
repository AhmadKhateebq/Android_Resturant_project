package com.example.resturantmanagment.service;

import com.example.resturantmanagment.model.OrderItem;
import com.example.resturantmanagment.resource.OrderItemRes;

import java.util.List;

public class OrderItemService {
    public static void addItems(List<OrderItem>items){
        for (OrderItem item : items) {
            OrderItemRes.add(item);
        }
    }
}
