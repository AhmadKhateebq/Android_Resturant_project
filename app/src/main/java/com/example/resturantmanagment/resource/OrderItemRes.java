package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.dto.ItemDto;
import com.example.resturantmanagment.model.OrderItem;
import com.example.resturantmanagment.resource.repository.CustomerRepository;
import com.example.resturantmanagment.resource.repository.ItemRepository;
import com.example.resturantmanagment.resource.repository.OrderItemRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderItemRes implements OrderItemRepository {
    static OrderItemRes INSTANCE;

    public static OrderItemRes getInstance() {
        if (INSTANCE == null){
            synchronized (EmployeeRes.class){
                if (INSTANCE == null){
                    INSTANCE = new OrderItemRes();
                }
            }
        }
        return INSTANCE;
    }
    public static int id = 6;
    private static ItemRepository itemRepository = ItemRes.getInstance();
    private static ArrayList<OrderItem> orderItems = new ArrayList<>() {{
        add(new OrderItem(0, 0, 0, 1, 10));
        add(new OrderItem(1, 0, 2, 2, 20));
        add(new OrderItem(2, 0, 1, 1, 10));
        add(new OrderItem(3, 1, 0, 1, 10));
        add(new OrderItem(4, 1, 2, 2, 20));
        add(new OrderItem(5, 2, 0, 1, 10));
    }};

    public OrderItem add(OrderItem orderItem) {
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

    public List<ItemDto> getItemsByOrderId(int id) {
        List<ItemDto> list = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getOrderId() == id) {
                ItemDto dto = new ItemDto(
                        itemRepository.findById(orderItem.getItemId()).getName(),
                        orderItem.getQuantity(),
                        orderItem.getPrice()
                );
                list.add(dto);
            }
        }
        return list;
    }
}
