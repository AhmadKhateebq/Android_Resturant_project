package com.example.resturantmanagment;

import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.resturantmanagment.model.TempUser;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public class VolleyService {
    static VolleyService INSTANCE;
    public static AtomicReference<Object> latestResponse = new AtomicReference<>(new TempUser("test","test"));
    private VolleyService() {
    }

    public static VolleyService getInstance() {
        if (INSTANCE == null)
            synchronized (VolleyService.class){
                if (INSTANCE == null)
                    INSTANCE = new VolleyService();
            }
        return INSTANCE;
    }
    public Object getData(String url, AppCompatActivity activity,Object body) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(activity);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                conv(body),
                response -> extracted(response,activity,body.getClass()),
                error -> error.printStackTrace()
        );
        mRequestQueue.add(jsonObjectRequest);
        return latestResponse;
    }
    private void extracted(JSONObject jsonObject,AppCompatActivity activity,Type classType) {
        Toast.makeText(
                activity,
                "Response :" + conv(jsonObject),
                Toast.LENGTH_LONG
        ).show();//display the response on screen
        printData(jsonObject,classType);
    }

    private Object printData(JSONObject response, Type object){
        latestResponse = new AtomicReference<>(conv(response,object));
        Log.i(this.getClass().getName(),latestResponse.toString());
        return latestResponse;
    }
    public Object conv(JSONObject object, Type classType){
        Gson gson = new Gson();
        return gson.fromJson(String.valueOf(object),classType);
    }

    public JSONObject conv(Object object){
        Log.i("start",object.toString());
        if(object.getClass() == Boolean.class){
            object = object.toString();
        }
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(gson.toJson(object));
            return jsonObject;
        } catch (JSONException e) {

            e.printStackTrace();
        }
        return null;
    }
}
