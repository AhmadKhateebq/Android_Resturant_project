package com.example.resturantmanagment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resturantmanagment.R;
import com.example.resturantmanagment.RestaurantService;
import com.example.resturantmanagment.model.TempUser;

public class MainActivity extends AppCompatActivity {

    RestaurantService service = RestaurantService.getInstance();
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void login(View view) {
        try {
            TempUser user = new TempUser(username.getText().toString(), password.getText().toString());
            if (service.verifyCustomer(user)) {
                Intent intent = new Intent(this, PrintActivity.class);
                intent.putExtra("username", user.getUsername());
                startActivity(intent);
            } else
                service.makeToast(this, "Wrong Username or Password");
        } catch (Exception ex) {
            service.makeToast(this,
                    "Please enter your login info");
        }
    }
}