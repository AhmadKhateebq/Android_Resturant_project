package com.example.resturantmanagment.resource;

import com.example.resturantmanagment.model.Item;
import com.example.resturantmanagment.resource.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemRes implements ItemRepository {
    static ItemRes INSTANCE;

    public static ItemRes getInstance() {
        if (INSTANCE == null){
            synchronized (EmployeeRes.class){
                if (INSTANCE == null){
                    INSTANCE = new ItemRes();
                }
            }
        }
        return INSTANCE;
    }
    public static ArrayList<Item> items = new ArrayList<>() {{
        add(new Item(0, "salad", 10, "salad"));
        add(new Item(1, "chicken salad", 10, "salad"));
        add(new Item(2, "chicken breast", 10, "main"));
        add(new Item(3, "Beef Burger", 10, "main"));
        add(new Item(4, "Fries", 10, "appetizers"));
    }};

    public Item findByName(String name) {
        for (Item item : items)
            if (item.getName().equals(name))
                return item;
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return items;
    }

    public Item findById(int id) {
        return items.get(id);
    }
}
