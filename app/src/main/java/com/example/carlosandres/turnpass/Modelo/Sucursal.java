package com.example.carlosandres.turnpass.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CarlosAndres on 01-11-2017.
 */

public class Sucursal extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "com.example.carlosandres.turnpass.Modelo.Sucursal.db";

    /**************************** VARIABLES DEFINIDOS EN DIAGRAMA DE CLASES ************************/
    public static String nombre_sucursal = "";
    public static List<String> servicios_sucursal = new ArrayList<String>();
    public static String direccion_sucursal = "";
    public static List<Integer> discapacidadesAptasParaSucursal = new ArrayList<Integer>();
    /***********************************************************************************************/


    public static final String TABLE_NAME = "com.example.carlosandres.turnpass.Modelo.Sucursal";
    /********************* VARIABLES DEFINIDOS EN EL MODELO RELACIONAL *************************/
    public static String COLUM_SUCURSAL_ID = "idsucursal";
    public static String COLUM_SUCURSAL_IDSERVICIO = "idservicio";
    public static String COLUM_SUCURSAL_IDDIRECCION = "iddireccionsucursal";
    public static String COLUM_SUCURSAL_SERVICIO = "servicio";
    /*******************************************************************************************/


    public Sucursal(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void Sucursal(String nomSucursal, String idsucursal, String idservicio, String iddireccion, String servicio){

        this.nombre_sucursal = nomSucursal;
        this.COLUM_SUCURSAL_ID = idsucursal;
        this.COLUM_SUCURSAL_IDDIRECCION = idservicio;
        this.COLUM_SUCURSAL_IDDIRECCION = iddireccion;
        this.COLUM_SUCURSAL_SERVICIO = servicio;
    }

    public static abstract class DatosTabla implements BaseColumns {

        /************************** VARIABLE PARA CREAR TABLA SUCURSAL *****************************/
        public static final String CREAR_TABLA =
                "CREATE TABLE " + TABLE_NAME + " ("+ COLUM_SUCURSAL_ID+
                        " INTEGER PRIMARY KEY, " + COLUM_SUCURSAL_IDSERVICIO+
                        " INTEGER, "+ COLUM_SUCURSAL_IDDIRECCION+
                        " INTEGER, "+ nombre_sucursal+
                        " TEXT, "+ COLUM_SUCURSAL_SERVICIO+
                        " TEXT)";
        /*******************************************************************************************/

        /************************* VARIABLE PARA BORRAR TABLA **************************************/
        public static final String BORRAR_TABLA =
                "DROP TABLE IF EXISTS +"+TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatosTabla.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //onUpgrade(sqLiteDatabase, i, i1);
        sqLiteDatabase.execSQL(DatosTabla.BORRAR_TABLA);
        onCreate(sqLiteDatabase);
    }

    public void onDelete(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(DatosTabla.BORRAR_TABLA);
    }
}
