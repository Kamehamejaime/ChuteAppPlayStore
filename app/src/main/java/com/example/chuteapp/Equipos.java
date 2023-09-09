package com.example.chuteapp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Equipos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

    }


}
