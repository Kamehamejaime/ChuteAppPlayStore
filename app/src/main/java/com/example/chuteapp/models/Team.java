package com.example.chuteapp.models;

import android.content.Context;

import com.example.chuteapp.DataHelper;

public class Team {
    DataHelper dh;
    String name;
    int qtyPlayers;
    byte logo;

    public Team(Context context, String name, int qtyPlayers) {
        dh = new DataHelper(context, "equipos", null, 1);
        this.name = name;
        this.qtyPlayers = qtyPlayers;
    }
}
