package com.example.chuteapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MisEquipos extends AppCompatActivity {

    ListView lista;
    EditText edtName;
    TextView id;
    private long selectedItemID;
    Button btnEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_equipos);
        lista = (ListView) findViewById(R.id.listaMisEquipos);
        btnEdit = (Button) findViewById(R.id.btnEditar);

        CargarLista();

    }
    public void CargarLista(){
        DataHelper dh = new DataHelper(this, "equipos.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT name FROM equipos", null);
        String[] arr = new String[c.getCount()];
        if(c.moveToFirst() == true){
            int i = 0;
            do{
                String linea =  c.getString(0) ;
                arr[i] = linea;
                i++;
            }while (c.moveToNext() == true);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_expandable_list_item_1, arr);
            lista.setAdapter(adapter);
            bd.close();
        }

        ListView listView = findViewById(R.id.listaMisEquipos);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Aquí por fin obtengo el ID del elemento seleccionado, profe lo logré :D
                selectedItemID = id;
                TextView txtEquipo = findViewById(R.id.idEquipo);
                txtEquipo.setText(String.valueOf(selectedItemID));


            }

        });

    }
    public void onClickCrear(View view){
        Intent intent = new Intent(this,Crear.class);
        startActivity(intent);
    }

    public void onClickEditar(View view){
        TextView id = (TextView) findViewById(R.id.idEquipo);
        // En ActivityA
        String txtId = id.getText().toString();

        Intent intent = new Intent(MisEquipos.this, Equipo.class);
        intent.putExtra("contenido", txtId);
        startActivity(intent);
    }
    public void onClickEliminar(View view){
        DataHelper dh = new DataHelper(this, "equipos.db",  null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        id = (TextView) findViewById(R.id.idEquipo);
        int iD = Integer.parseInt(id.getText().toString());
        long resp = bd.delete("equipos", "id="+ iD, null);
        Log.d("EliminarRegistro", "ID a eliminar: " + iD);

        bd.close();
        if(resp ==-1){
            Toast.makeText(this, "No se pudo Eliminar",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Equipo Eliminado",
                    Toast.LENGTH_LONG).show();
        }
        CargarLista();
    }

}