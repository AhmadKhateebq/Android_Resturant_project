package com.example.resturantmanagment.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantmanagment.R;
import com.example.resturantmanagment.service.OrderService;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        ArrayList<String>arr = OrderService.ordersReport();
        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.listview_item, arr);
        ListView listView = (ListView) findViewById(R.id.item_list);
        listView.setAdapter(adapter);
    }
}