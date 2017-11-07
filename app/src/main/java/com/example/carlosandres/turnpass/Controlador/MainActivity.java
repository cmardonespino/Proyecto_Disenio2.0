package com.example.carlosandres.turnpass.Controlador;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.carlosandres.turnpass.Modelo.BaseDeDatos;
import com.example.carlosandres.turnpass.Modelo.Servicio;
import com.example.carlosandres.turnpass.Modelo.Sucursal;
import com.example.carlosandres.turnpass.R;

import java.util.ArrayList;

/***************************** R E F E R E N C I A S *******************************/

/* https://developer.android.com/training/basics/firstapp/starting-activity.html */
/* https://stackoverflow.com/questions/6543811/intent-putextra-list */
/* https://developer.android.com/training/custom-views/create-view.html */
/* http://sqlitebrowser.org/ */
/* https://stackoverflow.com/questions/17529766/view-contents-of-database-file-in-android-studio */
/* https://developer.android.com/training/basics/data-storage/databases.html?hl=es-419 */
/* https://sqlite.org/cli.html */

/* LINK DE AYUDA PARA ACCEDER Y MOSTRAR DATOS DE BASE DE DATOS */
/* https://stackoverflow.com/questions/13006315/how-to-access-data-data-folder-in-android-device */
/* https://stackoverflow.com/questions/18370219/how-to-use-adb-in-android-studio-to-view-an-sqlite-db */

/* PARA MOSTRAR BASE DE DATOS DIRIGIRSE A TRAVES DEL TERMINAL A ~/AppData/Local/Android/Sdk/platform-tools */
/* LUEGO  ESCRIBIR ./adb shell */
/* LUEGO ESCRIBIR run-as <nombre de paquete>, en este caso com.example.carlosandres.turnpass */
/* ACCEDER A LA CARPETA databases */
/* escribir sqlite3 Sucursal.db */
/* PARA MOSTRAR DATOS, ESCRIBIR SELECT * FROM <nombre de tabla> */
/* PARA SALIR DE LA SHELL DE SQLITE3, ESCRIBIR .exit */
/* ENJOY :D */

/***********************************************************************************/

public class MainActivity extends AppCompatActivity {

    BaseDeDatos bdd;
    SQLiteDatabase basededatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*values.put(Servicio.FeedEntry.COLUM_SERVICIO_IDSUCURSAL, "2");
        values.put(Servicio.FeedEntry.COLUM_SERVICIO_IDTURNO, "2");
        values.put(Servicio.FeedEntry.COLUM_SERVICIO_NOMBRE, "Carnet");
        dbServicio.insert(Sucursal.FeedEntry.TABLE_NAME, null, values);*/
        bdd = new BaseDeDatos(this);

        if(BaseDeDatos.doesDatabaseExist(this, BaseDeDatos.DATABASE_NAME)==false){
            basededatos = bdd.getWritableDatabase(); //crea base de datos si no existe

            if( bdd.poblarTablaServicio(basededatos, 10, "Pasaporte")==true){
                if(bdd.poblarTablaServicio(basededatos, 11, "Carnet")==true){
                    if(bdd.poblarTablaDiscapacidad(basededatos, "2", "Fisica")==true){
                        if(bdd.poblarTablaDiscapacidad(basededatos, "1", "Sensorial")==true){
                            if(bdd.poblarTablaDiscapacidad(basededatos, "0", "Ninguna")==true){
                                Toast.makeText(getApplicationContext(), "Tablas principales pobladas correctamente", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }
            //ContentValues values = new ContentValues();
            /*values.put(BaseDeDatos.Servicio.COLUM_SERVICIO_ID, 10);
            values.put(BaseDeDatos.Servicio.COLUM_SERVICIO_NOMBRE, "Pasaporte");
            basededatos.insert(BaseDeDatos.Servicio.TABLE_NAME, null, values);
            values.clear();

            basededatos = bdd.getWritableDatabase();
            values.put(BaseDeDatos.Servicio.COLUM_SERVICIO_ID, 11);
            values.put(BaseDeDatos.Servicio.COLUM_SERVICIO_NOMBRE, "Carnet");
            basededatos.insert(BaseDeDatos.Servicio.TABLE_NAME, null, values);
            values.clear();*/

            /*
            basededatos = bdd.getWritableDatabase();
            values.put(BaseDeDatos.Discapacidad.COLUM_DISCAPACIDAD_NIVELPRIORIDAD, "2");
            values.put(BaseDeDatos.Discapacidad.COLUM_DISCAPACIDAD_NOMBRE, "Fisica");
            basededatos.insert(BaseDeDatos.Discapacidad.TABLE_NAME, null, values);
            values.clear();

            values.put(BaseDeDatos.Discapacidad.COLUM_DISCAPACIDAD_NIVELPRIORIDAD, "1");
            values.put(BaseDeDatos.Discapacidad.COLUM_DISCAPACIDAD_NOMBRE, "Sensorial");
            basededatos.insert(BaseDeDatos.Discapacidad.TABLE_NAME, null, values);
            values.clear();

            values.put(BaseDeDatos.Discapacidad.COLUM_DISCAPACIDAD_NIVELPRIORIDAD, "0");
            values.put(BaseDeDatos.Discapacidad.COLUM_DISCAPACIDAD_NOMBRE, "Ninguna");
            basededatos.insert(BaseDeDatos.Discapacidad.TABLE_NAME, null, values);
            values.clear();*/
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void agregarSucursal(View v){

        Intent intent = new Intent(this, LlenarTablaSucursal.class);
        intent.putStringArrayListExtra("test", null);
        startActivity(intent);
    }

    public void buscarSucursal(View v){

        Intent intent = new Intent(this, Opciones.class);
        intent.putStringArrayListExtra("test", null);

        if(bdd.verificarSiExistenDatosBaseDeDatos(basededatos)==true){
            startActivity(intent);
        }else
            Toast.makeText(getApplicationContext(), "NO EXISTEN DATOS EN LA BASE DE DATOS", Toast.LENGTH_LONG).show();
    }
}
