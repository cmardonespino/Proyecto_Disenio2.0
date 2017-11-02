package com.example.carlosandres.turnpass.Modelo;

import android.content.ContentValues;
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
    public static final String DATABASE_NAME = "Sucursal.db";
    /***********************************************************************************************/

    public static final String TABLE_NAME = "Sucursal";
    /********************* VARIABLES DEFINIDOS EN EL MODELO RELACIONAL *************************/
    public static final String COLUM_SUCURSAL_ID = "ID";
    public static final String COLUM_SUCURSAL_IDSERVICIO = "IDSERVICIO";
    public static final String COLUM_SUCURSAL_NOMBRE = "NOMBRESUCURSAL";
    public static final String COLUM_SUCURSAL_IDDIRECCION = "IDDIRECCION";
    public static final String COLUM_SUCURSAL_IDDISCAPACIDAD = "IDDISCAPACIDAD";
    /*******************************************************************************************/

    public static final String CREAR_TABLA =
            "CREATE TABLE " + TABLE_NAME + "("+COLUM_SUCURSAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    COLUM_SUCURSAL_IDSERVICIO + " VARCHAR, "+ COLUM_SUCURSAL_IDDIRECCION + " VARCHAR, "+
                    COLUM_SUCURSAL_IDDISCAPACIDAD+ " VARCHAR, "+COLUM_SUCURSAL_NOMBRE+" VARCHAR)";
    public static final String BORRAR_TABLA =
            "DROP TABLE IF EXISTS "+TABLE_NAME;


    public Sucursal(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade(sqLiteDatabase, i, i1);
        db.execSQL(BORRAR_TABLA);
        onCreate(db);
    }
}
