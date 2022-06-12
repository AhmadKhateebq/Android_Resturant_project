package com.example.resturantmanagment.resource.repository;

import com.example.resturantmanagment.dto.ItemDto;
import com.example.resturantmanagment.model.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    OrderItem add(OrderItem orderItem);

    List<ItemDto> getItemsByOrderId(int id);
}
