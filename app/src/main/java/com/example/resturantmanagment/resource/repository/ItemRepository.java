package com.example.resturantmanagment.resource.repository;

import com.example.resturantmanagment.model.Item;

public interface ItemRepository {
   Item findByName(String name);

   Item findById(int id);
}
