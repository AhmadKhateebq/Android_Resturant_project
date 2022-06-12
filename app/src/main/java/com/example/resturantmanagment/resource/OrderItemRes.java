package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.dto.ItemDto;
import com.example.resturantmanagment.model.Item;
import com.example.resturantmanagment.model.Order;
import com.example.resturantmanagment.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemRes {
    public static int id = 3;
    private static ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>() {{
        add(new OrderItem(0, 0, 0, 1, 10));
        add(new OrderItem(1, 0, 2, 2, 20));
        add(new OrderItem(2, 0, 1, 1, 10));
        add(new OrderItem(3, 1, 0, 1, 10));
        add(new OrderItem(4, 1, 2, 2, 20));
        add(new OrderItem(5, 2, 0, 1, 10));
    }};
    public static OrderItem add(OrderItem orderItem){
        OrderItem newOrderItem = new OrderItem(
                id++,
                orderItem.getOrderId(),
                orderItem.getItemId(),
                orderItem.getQuantity(),
                orderItem.getPrice()
        );
       orderItems.add(newOrderItem);
       return newOrderItem;
    }
    public static List<ItemDto> getItemsByOrderId(int id){
        List<ItemDto>list = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            if(orderItem.getOrderId() == id){
                ItemDto dto = new ItemDto(
                        ItemRes.findById(orderItem.getItemId()).getName(),
                        orderItem.getQuantity(),
                        orderItem.getPrice()
                );
                list.add(dto);
            }
        }
        return list;
    }
}
