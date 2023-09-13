package com.example.chuteapp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class StoreView extends AppCompatActivity {
    String[] itemList = {"Marco", "Icono", "Camiseta"};
    //int[] itemImages = {R.drawable.marco, R.drawable.gato_durmiendo, R.drawable.camiseta};
    int[] itemPrices = {300, 700, 500};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_view);
        //listView = findViewById(R.id.storeListView);
       // StoreBaseAdapter baseAdapter = new StoreBaseAdapter(getApplicationContext(), itemList, itemPrices);
        //listView.setAdapter(baseAdapter);
    }
}
