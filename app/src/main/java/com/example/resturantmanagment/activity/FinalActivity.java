package com.example.resturantmanagment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.resturantmanagment.R;
import com.example.resturantmanagment.model.Item;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        ArrayList<String>arr = new ArrayList<>();
        for (Item item : PrintActivity.list) {
            arr.add(item.toString());
        }
        Bundle bundle = getIntent().getExtras();
        int value = bundle.getInt("total");
        arr.add("Total = "+value+" $");
        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.listview_item, arr);

        ListView listView = (ListView) findViewById(R.id.item_list);
        listView.setAdapter(adapter);
    }
}