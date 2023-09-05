package com.example.chuteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //bloqueo de orientación de telefono por defecto Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //splashScreen con logo al inicio de la app con duración de 2 seg
        setTheme(R.style.Theme_ChuteApp);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Evento botón ingresar en pantalla inicio de sesión
    public void onClickIngreso(View view){
        Intent intent = new Intent(this, Ingreso.class);
        startActivity(intent);
    }
}