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

import com.example.carlosandres.turnpass.Modelo.BaseDeDatos;
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

        //mostrarDatos = (TableLayout)findViewById(R.id.tablaMostrarDatos);
    }

    public void funcion(View v){
        Sucursal s = new Sucursal();
        BaseDeDatos bdd = new BaseDeDatos(this);
        SQLiteDatabase db = bdd.getWritableDatabase();
        //Toast.makeText(getApplicationContext(), datosIngresados.get(0)+" "+datosIngresados.get(1), Toast.LENGTH_LONG).show();
        Cursor rs = s.mostrarDatosSucursal(db, datosIngresados.get(0), datosIngresados.get(1));
        //Toast.makeText(getApplicationContext(), rs.moveToFirst(),Toast.LENGTH_LONG).show();
        String str = "";
        StringBuilder sb = new StringBuilder();
        ContentValues cv = new ContentValues();

        if(rs.moveToFirst()){
            do{
                int columna = rs.getColumnCount();
                for(int i =0;i<columna;++i){
                    if(i%6==0)
                        sb.append(" / ");
                    sb.append(rs.getString(i));
                    if(i<columna-1)
                        sb.append(" - ");
                }
                //Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();
            }while(rs.moveToNext());
            Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();
            //str = rs.getString(rs.getColumnIndex("ID"));
            //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
            //rs.move(1);
        }
        rs.close();
    }
}
