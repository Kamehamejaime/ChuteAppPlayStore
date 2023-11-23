package com.example.chuteapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends MainActivity {
    private TextView username, email;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

    }

    public void onClickCrear(View view){
        Intent intent = new Intent(this,Crear.class);
        startActivity(intent);
    }

    public void onClickEquipos(View view){
        Intent intent = new Intent(this,Equipos.class);
        startActivity(intent);
    }
    public void onClickStore(View view){
        Intent intent = new Intent(this,StoreView.class);
        startActivity(intent);
    }

    public void onClickMisEquipos(View view){
        Intent intent = new Intent(this,MisEquipos.class);
        startActivity(intent);
    }
}
