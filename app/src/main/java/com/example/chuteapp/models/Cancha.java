package com.example.chuteapp.models;

import android.content.Context;

import com.example.chuteapp.DataHelper;

public class Cancha {
    DataHelper dh;
    String name, address;
    Double latitude, longitude;

    public Cancha(String name, String address, Double latitude, Double longitude) {
        dh = new DataHelper(null, "equipos.db", null, 1);
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
