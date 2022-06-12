package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.Order;
import com.example.resturantmanagment.model.enums.STATUS;

import java.util.ArrayList;
import java.util.List;

public class OrderRes {
    public static int id = 3;
    private static ArrayList<Order> orders = new ArrayList<Order>() {{
        add(new Order(0, 0,true, STATUS.ON_THE_WAY));
        add(new Order(1, 0,false, STATUS.COOKING));
        add(new Order(2, 1,true, STATUS.DONE));
    }};

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static Order addOrder(Order order){
        Order newOrder = new Order(id++, order.getCustomerId(), order.isOutside(), order.getStatus());
        orders.add(newOrder);
        return newOrder;
    }
    public static Order getOrder(int id){
        return orders.get(id);
    }
    public static List<Order> getByUserId(int id){
        List<Order>list = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId() == id)
                list.add(order);
        }
        return list;
    }
}
