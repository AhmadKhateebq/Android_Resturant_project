package com.example.resturantmanagment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.resturantmanagment.R;
import com.example.resturantmanagment.dto.OrderDto;
import com.example.resturantmanagment.model.Order;
import com.example.resturantmanagment.model.enums.ROLE;
import com.example.resturantmanagment.model.enums.STATUS;
import com.example.resturantmanagment.resource.OrderRes;
import com.example.resturantmanagment.service.EmpService;
import com.example.resturantmanagment.service.OrderService;

import java.util.ArrayList;

public class ChangeStatusActivity extends AppCompatActivity {

    Spinner empSpinner;
    Spinner orderSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status);
        empSpinner = findViewById(R.id.empSpinner);
        orderSpinner = findViewById(R.id.ordersSpinner);
        addEmpToSpinner();
        addOrdToSpinner();
    }

    public void changeStatus(View view) {
        Order order = getOrderFromDtoString(orderSpinner.getSelectedItem().toString()); ;
        EmpService.changeOrderStatus(order, ROLE.valueOf(empSpinner.getSelectedItem().toString()));
        Toast.makeText(this,order+" STATUS CHANGED",Toast.LENGTH_LONG).show();
        addOrdToSpinner();
    }
    private Order getOrderFromDtoString(String dto){
      String orderId = dto.split(" ")[1];
      return OrderRes.getOrder(Integer.parseInt(orderId));
    }
    private void addEmpToSpinner() {
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        new String[]{"SERVICE","CHEF","DELIVERY"});
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empSpinner.setAdapter(arrayAdapter);
    }
    private void addOrdToSpinner() {
        ArrayList<String> arr = new ArrayList<>();
        for (OrderDto allOrder : OrderService.getAllOrders()) {
            arr.add(allOrder.toSpinner());
        }
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderSpinner.setAdapter(arrayAdapter);
    }
}