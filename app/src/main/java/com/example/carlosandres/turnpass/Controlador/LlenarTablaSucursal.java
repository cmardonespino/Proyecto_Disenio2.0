package com.example.carlosandres.turnpass.Controlador;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carlosandres.turnpass.Modelo.BaseDeDatos;
import com.example.carlosandres.turnpass.Modelo.Sucursal;
import com.example.carlosandres.turnpass.R;

/* https://stackoverflow.com/questions/11044826/how-to-make-clearempty-without-values-spinner-on-clearbutton */

public class LlenarTablaSucursal extends AppCompatActivity {

    EditText nombresucursal, direccion;
    Spinner comuna, modulos, servicio;
    CheckBox discapacidad;
    String nomb, dir, comu, mod, serv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenar_tabla_sucursal);
    }

    public void agregarSucursal(View v){

        BaseDeDatos bdd = new BaseDeDatos(this);
        //Sucursal s = new Sucursal(this);
        SQLiteDatabase db = bdd.getWritableDatabase();
        SQLiteDatabase db1 = bdd.getReadableDatabase();
        ContentValues values = new ContentValues();

        nombresucursal = (EditText)findViewById(R.id.editTextNombreSucursal);
        nomb = nombresucursal.getText().toString();

        direccion = (EditText) findViewById(R.id.editTextDireccion);
        dir = direccion.getText().toString();

        comuna = (Spinner) findViewById(R.id.spinnerComuna);
        comu = comuna.getSelectedItem().toString();

        modulos = (Spinner) findViewById(R.id.spinnerModulos);
        mod = modulos.getSelectedItem().toString();

        servicio = (Spinner) findViewById(R.id.spinnerServicio);
        serv = servicio.getSelectedItem().toString();

        discapacidad = (CheckBox) findViewById(R.id.checkBoxDiscapacidad);

        if (nomb.equals("") || dir.equals("") || mod.equals("") || serv.equals("")) {
            comuna.setSelection(0);
            modulos.setSelection(0);
            servicio.setSelection(0);
            Toast.makeText(getApplicationContext(), "DEBE LLENAR TODOS LOS CAMPOS!", Toast.LENGTH_LONG).show();
            if(discapacidad.isChecked()){
                discapacidad.setChecked(false);
            }
        }else{
            //Cursor rs = s.verificarSiExisteSucursal(db, nomb, dir);
            //rs.moveToFirst();
            Sucursal sucursal = new Sucursal();
            if(sucursal.verificarSiExisteSucursal(db, nomb, dir, comu).getCount()>0){
                Toast.makeText(getApplicationContext(), "SUCURSAL YA ESTÁ REGISTRADA", Toast.LENGTH_LONG).show();
                nombresucursal.setText("");
                direccion.setText("");
                comuna.setSelection(0);
                modulos.setSelection(0);
                servicio.setSelection(0);
            }else {
                    // DISCAPACIDAD
                    // 1 = SI ES APTO PARA DISCAPACITADOS
                    // 0 = NO ES APTO PARA DISCAPACITADOS

                    if (discapacidad.isChecked()) {
                        values.put(BaseDeDatos.Sucursal.COLUM_SUCURSAL_IDDISCAPACIDAD, "1");
                    } else
                        values.put(BaseDeDatos.Sucursal.COLUM_SUCURSAL_IDDISCAPACIDAD, "0");

                    //values.put(Sucursal.COLUM_SUCURSAL_ID, 2); ESTA LINEA SE AGREGA SOLA CON LA ID INCREMENTADA.

                    // SERVICIO CARNET ID: 10
                    // SERVICIO PASAPORTE ID: 11
                    if (serv.equals("Pasaporte")) {
                        values.put(BaseDeDatos.Sucursal.COLUM_SUCURSAL_IDSERVICIO, "11");
                    } else if (serv.equals("Carnet")) {
                        values.put(BaseDeDatos.Sucursal.COLUM_SUCURSAL_IDSERVICIO, "10");
                    }
                    values.put(BaseDeDatos.Sucursal.COLUM_SUCURSAL_DIRECCION, dir);
                    values.put(BaseDeDatos.Sucursal.COLUM_SUCURSAL_COMUNA, comu);
                    values.put(BaseDeDatos.Sucursal.COLUM_SUCURSAL_NOMBRE, nomb);

                    if (db.insert(BaseDeDatos.Sucursal.TABLE_NAME, null, values) == -1)
                        Toast.makeText(getApplicationContext(), "SUCURSAL YA EXISTE", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "SUCURSAL INGRESADA AL SISTEMA CORRECTAMENTE", Toast.LENGTH_LONG).show();
                    db.close();

                    nombresucursal.setText("");
                    direccion.setText("");
                    discapacidad.setChecked(false);
                    comuna.setSelection(0);
                    modulos.setSelection(0);
                    servicio.setSelection(0);
            }
        }
    }
}
