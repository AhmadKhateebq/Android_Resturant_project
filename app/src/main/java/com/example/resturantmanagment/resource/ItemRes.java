package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.Item;

import java.util.ArrayList;

public class ItemRes {
    public static ArrayList<Item> items = new ArrayList<Item>() {{
        add(new Item(0, "salad", 10, "salad"));
        add(new Item(1, "chicken salad", 10, "salad"));
        add(new Item(2, "chicken breast", 10, "main"));
        add(new Item(3, "Beef Burger", 10, "main"));
        add(new Item(4, "Fries", 10, "appetizers"));
    }};
    public static Item findByName(String name){
        for (Item item : items)
            if (item.getName().equals(name))
                return item;
        return null;
    }
    public static Item findById(int id){
        return items.get(id);
    }
}
