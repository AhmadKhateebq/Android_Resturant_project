package com.example.resturantmanagment.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantmanagment.R;
import com.example.resturantmanagment.RestaurantService;
import com.example.resturantmanagment.dto.OrderDto;
import com.example.resturantmanagment.model.Order;
import com.example.resturantmanagment.model.enums.ROLE;

import java.util.ArrayList;

public class ChangeStatusActivity extends AppCompatActivity {

    RestaurantService service = RestaurantService.getInstance();
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
        Order order = getOrderFromDtoString(orderSpinner.getSelectedItem().toString());
        long id = orderSpinner.getSelectedItemId();
        service.changeOrderStatusByRole(order, ROLE.valueOf(empSpinner.getSelectedItem().toString()));
        service.makeToast(this, order + " STATUS CHANGED");
        addOrdToSpinner();
        orderSpinner.setSelection((int) id);
    }

    private Order getOrderFromDtoString(String dto) {
        String orderId = dto.split(" ")[1];
        return service.getOrderById(Integer.parseInt(orderId));
    }

    private void addEmpToSpinner() {
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        new String[]{"SERVICE", "CHEF", "DELIVERY"});
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empSpinner.setAdapter(arrayAdapter);
    }

    private void addOrdToSpinner() {
        ArrayList<String> arr = new ArrayList<>();

        for (OrderDto allOrder : service.getOrdersReportAsObject()) {
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