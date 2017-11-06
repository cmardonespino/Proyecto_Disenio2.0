package com.example.carlosandres.turnpass.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CarlosAndres on 01-11-2017.
 */

public class Sucursal {

    String nombre_sucursal="";
    int servicio=-1;
    String direccion="";
    boolean dispaciad=false;

    public Sucursal(){}

    public Cursor verificarSiExisteSucursal(SQLiteDatabase db, String nomb, String dir, String comu){
        return db.rawQuery("SELECT * FROM "+ BaseDeDatos.Sucursal.TABLE_NAME+ " WHERE NOMBRE_SUCURSAL = '"+nomb+"' AND DIRECCION='"+
                        dir+"' AND COMUNA = '"+comu+"'",
                null);
    }

    public Cursor verificarSiExisteSucursal(SQLiteDatabase db, String dir, String comu){
        return db.rawQuery("SELECT * FROM "+ BaseDeDatos.Sucursal.TABLE_NAME+ " WHERE DIRECCION = '"+dir+"' AND COMUNA='"+
                        comu+"'",
                null);
    }

    public Cursor mostrarDatosSucursal(SQLiteDatabase db, String comuna, String direccion){
        return db.rawQuery(BaseDeDatos.Sucursal.MOSTRAR_DATOS_TABLA+direccion+"' AND COMUNA='"+
                comuna+"'", null);
    }

}
