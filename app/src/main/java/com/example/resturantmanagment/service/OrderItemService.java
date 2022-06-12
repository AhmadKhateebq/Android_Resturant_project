package com.example.resturantmanagment.service;

import com.example.resturantmanagment.model.OrderItem;
import com.example.resturantmanagment.resource.OrderItemRes;
import com.example.resturantmanagment.resource.repository.OrderItemRepository;

import java.util.List;

public class OrderItemService {
    private static OrderItemRepository orderItemRepository = OrderItemRes.getInstance();
    public static void addItems(List<OrderItem>items){
        for (OrderItem item : items) {
            orderItemRepository.add(item);
        }
    }
}
