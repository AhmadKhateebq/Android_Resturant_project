package com.example.resturantmanagment.model.enums;

import android.util.Log;

public enum STATUS {
    DONE,
    WAITING_TO_PICKUP,
    WAITING_TO_SERVE,
    WAITING,
    COOKING,
    ON_THE_WAY;
    public static STATUS getStatus(String string){
        Log.d("status",string);
        if (string.equals("DONE"))
            return DONE;
        if (string.equals("WAITING_TO_PICKUP"))
            return WAITING_TO_PICKUP;
        if (string.equals("WAITING_TO_SERVE"))
            return WAITING_TO_SERVE;
        if (string.equals("WAITING"))
            return WAITING;
        if (string.equals("ON_THE_WAY"))
            return ON_THE_WAY;
        if (string.equals("COOKING"))
            return COOKING;
        return WAITING;
    }
}
