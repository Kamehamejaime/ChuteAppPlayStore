package com.example.chuteapp;

import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class Maps extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Configuration.getInstance().load(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        MapView mapview = findViewById(R.id.mapView);
        mapview.setTileSource(TileSourceFactory.MAPNIK);
        mapview.setBuiltInZoomControls(true);
        mapview.setMultiTouchControls(true);
        double santiagoLatitud = -33.4489;
        double santiagoLongitud = -70.6693;

        double sanjoaquinLatitud = -33.4989778;
        double sanjoaquinLongitud = -70.6180072;

        GeoPoint santiagoPoint = new GeoPoint(santiagoLatitud,santiagoLongitud);
        GeoPoint sanjoaquinPoint = new GeoPoint(sanjoaquinLatitud,sanjoaquinLongitud);

        Marker santiagoMarker = new Marker(mapview);
        santiagoMarker.setPosition(santiagoPoint);
        santiagoMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        santiagoMarker.setTitle("Santiago, Chile");
        santiagoMarker.setSnippet("El mejor pais de Chile");

        Marker sanjoaquinMarker = new Marker(mapview);
        sanjoaquinMarker.setPosition(sanjoaquinPoint);
        sanjoaquinMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        sanjoaquinMarker.setTitle("San Joaquin, Chile");
        sanjoaquinMarker.setSnippet("Santo Tomás, Tú puedes");

        //Agregar marcadores
        mapview.getOverlays().add(santiagoMarker);
        mapview.getOverlays().add(sanjoaquinMarker);

        //Centrar mapa
        IMapController mapController = mapview.getController();
        mapController.setCenter(santiagoPoint);
        mapController.setZoom(14);

    }


}
