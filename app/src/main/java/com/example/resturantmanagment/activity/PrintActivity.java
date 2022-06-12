package com.example.resturantmanagment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantmanagment.R;
import com.example.resturantmanagment.model.Customer;
import com.example.resturantmanagment.model.Item;
import com.example.resturantmanagment.resource.CustomerRes;
import com.example.resturantmanagment.resource.ItemRes;
import com.example.resturantmanagment.resource.OrderRes;
import com.example.resturantmanagment.service.ArrService;
import com.example.resturantmanagment.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class PrintActivity extends AppCompatActivity {
    Spinner spinner;
    TextView textView;
    Customer customer;
    Switch aSwitch;
    boolean out = true;
    public static List<Item> list = new ArrayList<>();
    int total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        spinner = findViewById(R.id.spinner);
        textView  = findViewById(R.id.description);
        aSwitch = findViewById(R.id.switch1);
        textView.setText("Total = 0$");
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("username");
        customer = CustomerRes.findByUsername(value);
        Toast.makeText(PrintActivity.this,"0 "+customer.toString(),Toast.LENGTH_LONG).show();
        addItemsToSpinner();

    }


    private void addItemsToSpinner() {
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        ArrService.toArray(ItemRes.items));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    public void submit_onClick(View view) {
        String item = spinner.getSelectedItem().toString();
        Toast.makeText(this,
                item,
                Toast.LENGTH_SHORT
        ).show();
        int id = Integer.parseInt(item.split(" ")[0])-1;
        Item menuItem = ItemRes.findById(id);
        list.add(menuItem);
        total+=menuItem.getPrice();
        textView.setText("Total = "+total +" $");
    }
    public void getItems(View view){
        OrderService.addOrder(list,customer,out);
        Intent intent = new Intent(PrintActivity.this,FinalActivity.class);
        intent.putExtra("total",this.total);
        startActivity(intent);
    }

    public void switchState(View view) {
        if(aSwitch.getText().equals("inside")){
            aSwitch.setText("outside");
            out = true;
        }else{
            aSwitch.setText("inside");
            out = false;
        }
    }
}
