package com.example.resturantmanagment.resource;

import android.util.Log;

import com.example.resturantmanagment.model.Order;
import com.example.resturantmanagment.model.enums.STATUS;
import com.example.resturantmanagment.resource.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRes implements OrderRepository {
    static OrderRes INSTANCE;

    public static OrderRes getInstance() {
        if (INSTANCE == null){
            synchronized (EmployeeRes.class){
                if (INSTANCE == null){
                    INSTANCE = new OrderRes();
                }
            }
        }
        return INSTANCE;
    }
    public static int id = 3;
    private static ArrayList<Order> orders = new ArrayList<>() {{
        add(new Order(0, 0, true, STATUS.ON_THE_WAY));
        add(new Order(1, 0, false, STATUS.COOKING));
        add(new Order(2, 1, true, STATUS.DONE));
    }};

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Order addOrder(Order order) {
        Order newOrder = new Order(id++, order.getCustomerId(), order.isOutside(), order.getStatus());
        orders.add(newOrder);
        orders.forEach(v-> Log.i("i",v.toString()));
        return newOrder;
    }

    public Order getOrder(int id) {
        return orders.get(id);
    }

    public List<Order> getByUserId(int id) {
        List<Order> list = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId() == id)
                list.add(order);
        }
        return list;
    }
}
