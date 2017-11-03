package com.example.carlosandres.turnpass.Controlador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.carlosandres.turnpass.R;

/* https://stackoverflow.com/questions/12702045/disable-checkbox-after-checked-android */

public class Opciones extends AppCompatActivity {

    CheckBox busquedaSucursal, busquedaServicio, busquedaUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
    }

    public void avanzarBusquedaSeleccionada(View v){

        busquedaSucursal = (CheckBox)findViewById(R.id.checkBoxPorSucursal);
        busquedaServicio = (CheckBox)findViewById(R.id.checkBoxPorServicio);
        busquedaUbicacion = (CheckBox)findViewById(R.id.checkBoxPorUbicacion);

        if(busquedaUbicacion.isChecked() && busquedaServicio.isChecked()
                || busquedaUbicacion.isChecked() && busquedaSucursal.isChecked()
                || busquedaSucursal.isChecked() && busquedaServicio.isChecked()){
            Toast.makeText(getApplicationContext(), "DEBE ESCOGER SOLO UNA OPCION", Toast.LENGTH_LONG).show();
            busquedaSucursal.setChecked(false);
            busquedaUbicacion.setChecked(false);
            busquedaServicio.setChecked(false);
        }else{
            if(busquedaSucursal.isChecked()){
                Intent intent = new Intent(this, BuscarPorSucursal.class);
                intent.putStringArrayListExtra("test", null);
                startActivity(intent);
                busquedaSucursal.setChecked(false);
            }else{
                if(busquedaServicio.isChecked()){
                    busquedaServicio.setChecked(false);
                    Toast.makeText(getApplicationContext(), "OPCIONES EN DESARROLLO", Toast.LENGTH_LONG).show();
                }else if(busquedaUbicacion.isChecked()){
                    busquedaUbicacion.setChecked(false);
                    Toast.makeText(getApplicationContext(), "OPCIONES EN DESARROLLO", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "DEBE ESCOGER UNA OPCION", Toast.LENGTH_LONG).show();
                }

            }
        }

        /*
        if(busquedaServicio.isChecked()){
            busquedaSucursal.setEnabled(false);
            busquedaUbicacion.setEnabled(false);
        }
        */
    }
}
