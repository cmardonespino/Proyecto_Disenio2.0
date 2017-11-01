package com.example.carlosandres.turnpass.Controlador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import java.util.ArrayList;

import com.example.carlosandres.turnpass.Modelo.Sucursal;
import com.example.carlosandres.turnpass.R;

public class LlenarTablas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenar_tablas);
    }

    public void llenarTablas(View vistaLlenarTablas){
        String nombreSucursal = ((EditText)findViewById(R.id.editTextNombreSucursal)).getText().toString();
        String comuna = ((Spinner)findViewById(R.id.spinnerComunas)).getSelectedItem().toString();
        String modulos = ((Spinner)findViewById(R.id.spinnerCantidaddeModulos)).getSelectedItem().toString();
        String direccion = ((EditText)findViewById(R.id.editTextDireccion)).getText().toString();

        ArrayList<Integer> arl = new ArrayList<Integer>();
        // 1 en caso de que si fue chequeado
        // 0 en caso de que no fue chequeado

        if(((RadioButton)findViewById(R.id.radioButtonPasaporte)).isChecked()){
            String pasaporte = "1";
            arl.add(1);
        }else {
            String pasaporte = "0";
            arl.add(0);
        }
        if(((RadioButton)findViewById(R.id.radioButtonCarnet)).isChecked()){
            String carnet = "0";
            arl.add(1);
        }else{
            String carnet = "1";
            arl.add(0);
        }
        //String radioButtonPasaporte = ((RadioButton)findViewById(R.id.radioButtonPasaporte));
        //String radioButtonCarnet = (RadioButton)findViewById(R.id.radioButtonCarnet);

        Sucursal s = new Sucursal(this);

    }
}
