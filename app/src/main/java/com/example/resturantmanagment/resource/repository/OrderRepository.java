package com.example.resturantmanagment.resource.repository;

import com.example.resturantmanagment.model.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {
    ArrayList<Order> getOrders();

    Order addOrder(Order order);

    Order getOrder(int id);

    List<Order> getByUserId(int id);
}
