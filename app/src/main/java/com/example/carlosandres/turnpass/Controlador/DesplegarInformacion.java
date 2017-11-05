package com.example.carlosandres.turnpass.Controlador;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosandres.turnpass.Modelo.Sucursal;
import com.example.carlosandres.turnpass.R;

import java.util.List;
import java.util.Objects;

public class DesplegarInformacion extends AppCompatActivity {

    List<String> datosIngresados;
    TableLayout mostrarDatos;
    TableRow rowHeader, row1, row2, row3, row4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplegar_informacion);
        datosIngresados = getIntent().getStringArrayListExtra("test");

        mostrarDatos = (TableLayout)findViewById(R.id.tablaMostrarDatos);
        //Toast.makeText(getApplicationContext(), "datosIngresados: "+datosIngresados.get(0), Toast.LENGTH_LONG).show();
    }

    public void funcion(View v){
        Sucursal s = new Sucursal(this);
        SQLiteDatabase db = s.getWritableDatabase();
        Cursor rs = s.mostrarDatos(db, "adasd");
        String str = "";
        StringBuilder sb = new StringBuilder();
        ContentValues cv = new ContentValues();

        s.setNombre_sucursal("prueba1");
        String a = s.getNombre_sucursal();

        if(rs.moveToFirst()){
            do{
                int columna = rs.getColumnCount();
                for(int i =0;i<columna;++i){
                    if(i%5==0)
                        sb.append(" / ");
                    sb.append(rs.getString(i));
                    if(i<columna-1)
                        sb.append(" - ");
                }
                //Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();
            }while(rs.moveToNext());
            Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();
            //str = rs.getString(rs.getColumnIndex("ID"));
            //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
            //rs.move(1);
        }
        rs.close();

        /*rs.moveToFirst();
        long nombre = rs.getLong(rs.getColumnIndex("prueba1"));
        long title = rs.getLong(rs.getColumnIndex("ID"));
        Toast.makeText(getApplicationContext(), Long.toString(nombre), Toast.LENGTH_LONG).show();*/
    }
}
