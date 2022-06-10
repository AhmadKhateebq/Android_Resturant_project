package com.example.resturantmanagment.activity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.resturantmanagment.R;
import com.example.resturantmanagment.model.TempUser;
import com.example.resturantmanagment.resource.CustomerRes;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ERROR";
    EditText username;
    EditText password;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("hello");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }
    public void login(View view){
        try {
           TempUser user = new TempUser(username.getText().toString(),password.getText().toString());
            if (CustomerRes.verify(user)){
                Intent intent = new Intent(this, PrintActivity.class);
                intent.putExtra("username", user.getUsername());
                startActivity(intent);
            }
            else
                Toast.makeText(MainActivity.this, "Wring Username or Password", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Log.e(TAG,ex.getMessage());
            Toast.makeText(MainActivity.this,
                    "Please enter your login info", Toast.LENGTH_SHORT).show();
        }
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, PrintActivity.class);
        String message = "just a test";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}