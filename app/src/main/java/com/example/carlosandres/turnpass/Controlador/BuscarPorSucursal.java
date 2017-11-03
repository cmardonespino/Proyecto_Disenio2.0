package com.example.carlosandres.turnpass.Controlador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carlosandres.turnpass.R;

import java.util.ArrayList;
import java.util.List;

/* https://stackoverflow.com/questions/9553496/how-to-select-first-item-of-a-spinner-in-a-test */

public class BuscarPorSucursal extends AppCompatActivity {

    EditText direccion;
    Spinner comuna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_por_sucursal);
    }

    public void buscarSucursalYdesplegarInformacion(View v){

        direccion = (EditText)findViewById(R.id.editTextIngresarDireccion);
        comuna = (Spinner)findViewById(R.id.spinnerComuna);

        if(direccion.getText().toString().equals("") || comuna.getSelectedItem().toString().equals("")){
            Toast.makeText(getApplicationContext(), "DEBE LLENAR TODOS LOS CAMPOS", Toast.LENGTH_LONG).show();
        }else{

            List<String> datosIngresados;
            datosIngresados = new ArrayList<String>();
            datosIngresados.add(comuna.getSelectedItem().toString());
            datosIngresados.add(direccion.getText().toString());

            Intent intent = new Intent(this, DesplegarInformacion.class);
            intent.putStringArrayListExtra("test", (ArrayList<String>) datosIngresados);
            direccion.setText("");
            comuna.setSelection(0);
            startActivity(intent);
        }
    }

}
