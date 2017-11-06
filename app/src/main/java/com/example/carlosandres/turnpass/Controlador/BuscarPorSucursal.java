package com.example.carlosandres.turnpass.Controlador;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carlosandres.turnpass.Modelo.BaseDeDatos;
import com.example.carlosandres.turnpass.Modelo.Sucursal;
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

        BaseDeDatos bdd = new BaseDeDatos(this);

        direccion = (EditText)findViewById(R.id.editTextIngresarDireccion);
        comuna = (Spinner)findViewById(R.id.spinnerComuna);

        String comuna_nombre="";
        String direccion_nombre="";

        if(direccion.getText().toString().equals("") || comuna.getSelectedItem().toString().equals("")){
            Toast.makeText(getApplicationContext(), "DEBE LLENAR TODOS LOS CAMPOS", Toast.LENGTH_LONG).show();
        }else{

            Sucursal s = new Sucursal();
            SQLiteDatabase db = bdd.getWritableDatabase();
            comuna_nombre = comuna.getSelectedItem().toString();
            direccion_nombre = direccion.getText().toString();

            /*Toast.makeText(getApplicationContext(), "DIRECCION: "+direccion_nombre+" COMUNA: "+
                    comuna_nombre, Toast.LENGTH_LONG).show();*/

            if(s.verificarSiExisteSucursal(db, direccion_nombre, comuna_nombre).getCount()==0){
                Toast.makeText(getApplicationContext(), "NO EXISTE SUCURSAL DE ACUERDO A LOS DATOS INGRESADOS",
                        Toast.LENGTH_LONG).show();
            }else{
                //Toast.makeText(getApplicationContext(), "SI COINCIDEN DATOS", Toast.LENGTH_LONG).show();
                List<String> datosIngresados;
                datosIngresados = new ArrayList<String>();
                datosIngresados.add(comuna_nombre);
                datosIngresados.add(direccion_nombre);

                Intent intent = new Intent(this, DesplegarInformacion.class);
                intent.putStringArrayListExtra("test", (ArrayList<String>) datosIngresados);
                direccion.setText("");
                comuna.setSelection(0);
                startActivity(intent);
            }
        }
    }

}
