package com.example.carlosandres.turnpass.Controlador;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carlosandres.turnpass.Modelo.Sucursal;
import com.example.carlosandres.turnpass.R;

public class LlenarTablaSucursal extends AppCompatActivity {

    EditText nombresucursal, direccion;
    Spinner comuna, modulos, servicio;
    RadioButton discapacidad;
    String nomb, dir, comu, mod, serv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenar_tabla_sucursal);
    }

    public void agregarSucursal(View v){

        Sucursal s = new Sucursal(this);
        SQLiteDatabase db = s.getWritableDatabase();
        ContentValues values = new ContentValues();

        nombresucursal = (EditText)findViewById(R.id.editTextNombreSucursal);
        nomb = nombresucursal.getText().toString();

        direccion = (EditText)findViewById(R.id.editTextDireccion);
        dir = direccion.getText().toString();

        comuna = (Spinner)findViewById(R.id.spinnerComuna);
        comu = comuna.getSelectedItem().toString();

        modulos = (Spinner)findViewById(R.id.spinnerModulos);
        mod = modulos.getSelectedItem().toString();

        servicio = (Spinner)findViewById(R.id.spinnerServicio);
        serv = servicio.getSelectedItem().toString();

        if(nomb.equals("") || dir.equals("") || mod.equals("") || serv.equals("")){
            Toast.makeText(getApplicationContext(), "DEBE LLENAR TODOS LOS CAMPOS!", Toast.LENGTH_LONG).show();
        }else{
            // DISCAPACIDAD
            // 1 = SI ES APTO PARA DISCAPACITADOS
            // 2 = NO ES APTO PARA DISCAPACITADOS
            discapacidad = (RadioButton)findViewById(R.id.radioButtonDiscapacidad);
            if(discapacidad.isChecked()){
                values.put(Sucursal.COLUM_SUCURSAL_IDDISCAPACIDAD, "1");
            }else
                values.put(Sucursal.COLUM_SUCURSAL_IDDISCAPACIDAD, "0");

            //values.put(Sucursal.COLUM_SUCURSAL_ID, 2); ESTA LINEA SE AGREGA SOLA CON LA ID INCREMENTADA.

            // SERVICIO CARNET ID: 10
            // SERVICIO PASAPORTE ID: 11
            if(serv.equals("Pasaporte")){
                values.put(Sucursal.COLUM_SUCURSAL_IDSERVICIO, "11");
            }else if(serv.equals("Carnet")){
                values.put(Sucursal.COLUM_SUCURSAL_IDSERVICIO, "10");
            }
            values.put(Sucursal.COLUM_SUCURSAL_IDDIRECCION, "0");
            values.put(Sucursal.COLUM_SUCURSAL_NOMBRE, nomb);

            if(db.insert(Sucursal.TABLE_NAME, null, values)==-1)
                Toast.makeText(getApplicationContext(), "SUCURSAL YA EXISTE", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "SUCURSAL INGRESADA AL SISTEMA CORRECTAMENTE", Toast.LENGTH_LONG).show();
            db.close();
        }
    }
}
