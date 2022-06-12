package com.example.resturantmanagment.service;

import com.example.resturantmanagment.dto.ItemDto;
import com.example.resturantmanagment.dto.OrderDto;
import com.example.resturantmanagment.model.Customer;
import com.example.resturantmanagment.model.Item;
import com.example.resturantmanagment.model.Order;
import com.example.resturantmanagment.model.OrderItem;
import com.example.resturantmanagment.model.enums.STATUS;
import com.example.resturantmanagment.resource.CustomerRes;
import com.example.resturantmanagment.resource.OrderItemRes;
import com.example.resturantmanagment.resource.OrderRes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderService {

    public static Order addOrder(List<Item> items, Customer customer){
        Order order = new Order();
        order.setCustomerId(customer.getId());
        order.setStatus(STATUS.WAITING);
        order = OrderRes.addOrder(order);

        HashMap<Item,Integer> itemsMap = new HashMap<>();
        HashMap<Item,OrderItem> orderItems = new HashMap<>();
        for (Item item : items) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setItemId(item.getId());
            if (!itemsMap.containsKey(item)){
                itemsMap.put(item,1);
                orderItem.setQuantity(1);
            }else {
                itemsMap.put(item,itemsMap.get(item)+1);
                orderItem.setQuantity(itemsMap.get(item));
            }
            orderItem.setPrice(item.getPrice()*orderItem.getQuantity());
            orderItems.put(item,orderItem);
        }
        List<OrderItem>list = new ArrayList<>();
        orderItems.forEach((k,v)-> list.add(v));
        OrderItemService.addItems(list);
        return order;
    }
    public static List<OrderDto> getAllOrders(){
        List<OrderDto> list = new ArrayList<>();
        for (Order order : OrderRes.getOrders()) {
            OrderDto dto = new OrderDto();
            dto.setOrderId(order.getId());
            dto.setCustomerName(CustomerRes.findById(order.getCustomerId()).getName());
            dto.setStatus(order.getStatus());
            dto.setItems(OrderItemRes.getItemsByOrderId(order.getId()));
            list.add(dto);
        }
        return list;
    }
    public static ArrayList<String> ordersReport(){
        ArrayList<String>arr = new ArrayList<>();
        int total = 0;
        for (OrderDto allOrder : OrderService.getAllOrders()) {
            arr.add(allOrder.toString());
            for (ItemDto item : allOrder.getItems()) {
                total+=item.getPrice();
            }
        }
        arr.add("Total = "+total+" $");
        return arr;
    }

}
