package com.example.chuteapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Ingreso extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

    }
    public void onClickEquipos(View view){
        Intent intent = new Intent(this,Equipos.class);
        startActivity(intent);
    }

    public void onClickPerfil(View view){
        Intent intent = new Intent(this,Perfil.class);
        startActivity(intent);
    }
    public void onClickCrear(View view){
        Intent intent = new Intent(this,Crear.class);
        startActivity(intent);
    }

}
