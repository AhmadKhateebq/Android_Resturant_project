package com.example.resturantmanagment.service;

import com.example.resturantmanagment.model.Item;
import com.example.resturantmanagment.model.Order;

import java.util.List;

public class ArrService {

    public static String[] toArray(List items) {
        String [] arr = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            arr[i]=items.get(i).toString();
        }
        return arr;
    }

}
