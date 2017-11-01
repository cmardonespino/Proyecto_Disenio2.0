package com.example.carlosandres.turnpass.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by CarlosAndres on 01-11-2017.
 */

public class Turno extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "com.example.carlosandres.turnpass.Modelo.Turno.db";

    /**************************** VARIABLES DEFINIDOS EN DIAGRAMA DE CLASES ************************/
    public static final String nombreTurno = "";
    public static final String tiempoParaTurno = "";
    /***********************************************************************************************/

    public Turno(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    public static abstract class DatosTabla implements BaseColumns {
        public static final String TABLE_NAME = "com.example.carlosandres.turnpass.Modelo.Turno";

        /********************* VARIABLES DEFINIDOS EN EL MODELO RELACIONAL *************************/
        public static final String id_turno = "";
        public static final String id_cliente = "";
        public static final String id_servicio = "";
        public static final String nombre_turno = "";
        /*******************************************************************************************/

        /************************** VARIABLE PARA CREAR TABLA TURNO *****************************/
        public static final String CREAR_TABLA =
                "CREATE TABLE " + Turno.DatosTabla.TABLE_NAME + " ("+ DatosTabla.id_turno+
                        " INTEGER PRIMARY KEY, " + DatosTabla.id_cliente+
                        " INTEGER, "+ DatosTabla.id_servicio+
                        " INTEGER, "+ DatosTabla.nombre_turno+
                        " TEXT)";
        /*******************************************************************************************/

        /************************* VARIABLE PARA BORRAR TABLA **************************************/
        public static final String BORRAR_TABLA =
                "DROP TABLE IF EXISTS +"+ Turno.DatosTabla.TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Turno.DatosTabla.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Turno.DatosTabla.BORRAR_TABLA);
        onCreate(sqLiteDatabase);
    }

    public void onDelete(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(Turno.DatosTabla.BORRAR_TABLA);
    }
}
