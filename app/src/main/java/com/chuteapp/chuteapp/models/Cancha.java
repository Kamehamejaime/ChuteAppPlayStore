package com.chuteapp.chuteapp.models;

import android.content.Context;

import com.chuteapp.chuteapp.DataHelper;

public class Cancha {
    DataHelper dh;
    String name, address;
    Double latitude, longitude;

    public Cancha(Context context, String name, String address, Double latitude, Double longitude) {
        dh = new DataHelper(context, "cahnchas", null, 1);
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
