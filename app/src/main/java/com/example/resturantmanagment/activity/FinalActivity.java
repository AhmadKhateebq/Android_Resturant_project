package com.example.resturantmanagment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantmanagment.R;
import com.example.resturantmanagment.RestaurantService;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {
    RestaurantService service = RestaurantService.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        ArrayList<String>arr = service.getOrdersReportAsString();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.listview_item, arr);
        ListView listView = findViewById(R.id.item_list);
        listView.setAdapter(adapter);
    }

    public void goToChangeStatus(View view) {
        Intent intent = new Intent(this,ChangeStatusActivity.class);
        startActivity(intent);
    }
}