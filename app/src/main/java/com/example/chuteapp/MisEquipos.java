package com.example.chuteapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MisEquipos extends AppCompatActivity {

    ListView lista;
    EditText edtName;

    TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_equipos);
        lista = (ListView) findViewById(R.id.listaMisEquipos);
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
    }
    public void onClickCrear(View view){
        Intent intent = new Intent(this,Crear.class);
        startActivity(intent);
    }

    public void onClickModificar(View view){
        DataHelper dh = new DataHelper(this, "equipos.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        reg.put("name", edtName.getText().toString());
        long resp  = bd.update("equipos", reg, "id=?", new String[]
                {id.getText().toString()});
        bd.close();
        if(resp == -1){
            Toast.makeText(this, "No se pudo Modificar",
                    Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Equipo Modificado",
                    Toast.LENGTH_LONG).show();
        }
        CargarLista();
    }

    public void onClickEliminar(View view){
        DataHelper dh = new DataHelper(this, "equipos.db",  null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        String bId = id.getText().toString();
        long resp = bd.delete("equipos", "id="+ bId, null);
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