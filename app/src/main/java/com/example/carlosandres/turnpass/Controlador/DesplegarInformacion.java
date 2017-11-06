package com.example.carlosandres.turnpass.Controlador;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosandres.turnpass.Modelo.BaseDeDatos;
import com.example.carlosandres.turnpass.Modelo.Servicio;
import com.example.carlosandres.turnpass.Modelo.Sucursal;
import com.example.carlosandres.turnpass.Modelo.Usuario;
import com.example.carlosandres.turnpass.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DesplegarInformacion extends AppCompatActivity {

    List<String> datosIngresados;
    LinearLayout mostrarDatos;
    TableRow rowHeader, row1, row2, row3, row4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplegar_informacion);


        Sucursal s = new Sucursal();
        BaseDeDatos bdd = new BaseDeDatos(this);
        SQLiteDatabase db = bdd.getWritableDatabase();

        StringBuilder sb = new StringBuilder();
        ContentValues cv = new ContentValues();

        datosIngresados = getIntent().getStringArrayListExtra("test");

        //Toast.makeText(getApplicationContext(), datosIngresados.get(0)+" "+datosIngresados.get(1),Toast.LENGTH_LONG).show();
        //Cursor rs = s.mostrarDatosSucursal(db, datosIngresados.get(0), datosIngresados.get(1));
        ArrayList<Sucursal> sucursal = new ArrayList<Sucursal>();
        sucursal = s.capturarDatos(db, datosIngresados.get(1), datosIngresados.get(0));
        if(sucursal.isEmpty()){
            Toast.makeText(getApplicationContext(), "PROBLEMAS AL CAPTURAR DATOS", Toast.LENGTH_LONG).show();
        }else{
            //Toast.makeText(getApplicationContext(), "NO SE QUE HUEA "+sucursal.get(0).getNombre_sucursal(), Toast.LENGTH_LONG).show();
            TextView a = (TextView)findViewById(R.id.nombreSucursal);
            a.setText(sucursal.get(0).getNombre_sucursal());


            TextView b = (TextView)findViewById(R.id.servicioSucursal);
            Servicio s1 = new Servicio();

            ArrayList<Servicio> b1 = new ArrayList<Servicio>();
            Toast.makeText(getApplicationContext(), sucursal.get(0).getServicio(), Toast.LENGTH_LONG).show();
            b1 = s1.consultarServicio(db, sucursal.get(0).getServicio());
            b.setText(b1.get(0).getNombre_servicio());
            //Toast.makeText(getApplicationContext(), b1.get(0).getNombre_servicio(), Toast.LENGTH_LONG).show();


            TextView c = (TextView)findViewById(R.id.direccionSucursal);
            c.setText(sucursal.get(0).getDireccion());
            TextView d = (TextView)findViewById(R.id.comunaSucursal);
            d.setText(sucursal.get(0).getComuna());

            TextView f = (TextView)findViewById(R.id.modulosSucursal);
            f.setText(sucursal.get(0).getModulos());

            TextView e = (TextView)findViewById(R.id.discapacidadSucursal);

            //ENTRA PRIMERO COMUNA (0) Y LUEGO DIRECCION (1)
            Usuario u1 = new Usuario();
            ArrayList<Usuario> f1 = new ArrayList<Usuario>();
            //Toast.makeText(getApplicationContext(), "ID DISCAPACIDAD: "+sucursal.get(0).getDiscapacidad(),Toast.LENGTH_LONG).show();
            f1 = u1.consultarDiscapacidad(db, sucursal.get(0).getDiscapacidad());
            //Toast.makeText(getApplicationContext(), sucursal.get(0).getDiscapacidad(), Toast.LENGTH_LONG ).show();
            f1 = u1.consultarDiscapacidad(db, sucursal.get(0).getDiscapacidad());

            e.setText(f1.get(0).getDiscapacidad());
        }
    }

    public void funcion(View v){
        //Toast.makeText(getApplicationContext(), datosIngresados.get(0)+" "+datosIngresados.get(1), Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), rs.moveToFirst(),Toast.LENGTH_LONG).show();
        CheckBox f = (CheckBox)findViewById(R.id.checkBoxSeleccionar);
        if(f.isChecked()){
            //Toast.makeText(getApplicationContext(),"TURNO TOMADO", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MostrarTurnoTomado.class);
            List<String> datosIngresados;
            datosIngresados = new ArrayList<String>();

            TextView a = (TextView)findViewById(R.id.nombreSucursal);
            String nombre = a.getText().toString();
            TextView b = (TextView)findViewById(R.id.servicioSucursal);
            String servicio = b.getText().toString();
            TextView c = (TextView)findViewById(R.id.discapacidadSucursal);
            String discapacidad = c.getText().toString();

            datosIngresados.add(nombre);
            datosIngresados.add(servicio);
            datosIngresados.add(discapacidad);

            intent.putStringArrayListExtra("test", (ArrayList<String>) datosIngresados);
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "DEBE SELECCIONAR UNA SUCURSAL PARA SOLICITAR TURNO", Toast.LENGTH_LONG).show();
        }
        /*
        if(rs.moveToFirst()){
            do{
                int columna = rs.getColumnCount();
                for(int i =0;i<columna;++i){
                    if(i%6==0){
                        sb.append(" / ");
                    }
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
        }*/
    }
}
