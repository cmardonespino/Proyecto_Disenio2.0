package com.example.carlosandres.turnpass.Controlador;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickBtn(View v){

        Intent intent = new Intent(this, LlenarTablaSucursal.class);
        intent.putStringArrayListExtra("test", null);
        startActivity(intent);
    }
}
