package com.example.resturantmanagment;

import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

public class VolleyService {
    static VolleyService INSTANCE;
    public Object latestResponse = new Object();
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
    public void getData(String url, AppCompatActivity activity,Object body) throws JSONException {
        RequestQueue mRequestQueue = Volley.newRequestQueue(activity);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                conv(body),
                response -> extracted(response,activity,body.getClass()),
                error -> Log.i(this.getClass().getName(), "Error :" + error)
        );
        mRequestQueue.add(jsonObjectRequest);
    }
    private void extracted(JSONObject jsonObject,AppCompatActivity activity,Type classType) {
        Toast.makeText(
                activity,
                "Response :" + conv(jsonObject),
                Toast.LENGTH_LONG
        ).show();//display the response on screen
        printData(jsonObject,classType);
    }
    private void printData(JSONObject response,Type object){
        latestResponse = conv(response,object);
        Log.i(this.getClass().getName(),latestResponse.toString());
    }
    private Object conv(JSONObject object, Type classType){
        Gson gson = new Gson();
        return gson.fromJson(String.valueOf(object),classType);
    }

    private JSONObject conv(Object object){
        Gson gson = new Gson();
        try {
            return new JSONObject(gson.toJson(object));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
