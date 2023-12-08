package com.chuteapp.chuteapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NuevoEquipo extends AppCompatActivity {

    private EditText nombre, cupos, direccion;
    private ListView lista;

    //Variable conexion FireStore
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_equipo);
        //Llamar método cargar lista
        CargarListaFireStore();
        //inicializar Firestore
        db =FirebaseFirestore.getInstance();

        //Unir variables
        nombre = findViewById(R.id.nombre);
        cupos = findViewById(R.id.cupos);
        direccion = findViewById(R.id.direccion);
        lista = findViewById(R.id.lstEquipos);

    }

    public void CargarListaFireStore(){
        //Obtener instancia de firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //consulta a colección equipos
        db.collection("equipos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            List<String> listaEquipos = new ArrayList<>();

                            for (QueryDocumentSnapshot document : task.getResult()){
                                String linea = " | " + document.getString("Nombre") + " | " +
                                        document.getString("Cupos") + " | " +
                                        document.getString("Dirección");
                                listaEquipos.add(linea);
                            }

                            ArrayAdapter<String> adapter = new ArrayAdapter<>(NuevoEquipo.this,
                                    android.R.layout.simple_list_item_1, listaEquipos);
                            lista.setAdapter(adapter);
                        }else{
                            Log.e("Tag","Error al obtener datos",task.getException());
                        }
                    }
                });

    }

    public void enviarDatosFirestore(View view){
        String name =  nombre.getText().toString();
        String quotas = cupos.getText().toString();
        String address = direccion.getText().toString();

        //mapear datos a enviar
        Map<String, Object> equipo = new HashMap<>();
        equipo.put("Nombre",name);
        equipo.put("Cupos",quotas+" cupos");
        equipo.put("Dirección",address);

        db.collection("equipos")
                .document(name)
                .set(equipo)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Equipo creado", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error al crear equipo", Toast.LENGTH_SHORT).show();
                });
    }

    //Boton cargar lista
    public void CargarLista(View view){
        CargarListaFireStore();
    }


}
