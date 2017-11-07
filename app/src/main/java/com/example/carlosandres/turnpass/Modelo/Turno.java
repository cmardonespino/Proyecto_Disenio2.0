package com.example.carlosandres.turnpass.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by CarlosAndres on 01-11-2017.
 */

public class Turno{

    /**************************** VARIABLES DEFINIDOS EN DIAGRAMA DE CLASES ************************/
    String nombreTurno = "";
    String tiempoParaTurno = "";
    /***********************************************************************************************/

    public Turno(String nombre, String tiempo){
        this.nombreTurno=nombre;
        this.tiempoParaTurno=tiempo;
    }

    public Turno(){}

    public String getNombreTurno() {
        return nombreTurno;
    }

    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
    }

    public String getTiempoParaTurno() {
        return tiempoParaTurno;
    }

    public void setTiempoParaTurno(String tiempoParaTurno) {
        this.tiempoParaTurno = tiempoParaTurno;
    }

    public boolean asignarTurno(SQLiteDatabase db, String run, String nombreSucursal, String servicioSucursal){
        try{
            ContentValues values = new ContentValues();
            /*db.execSQL("INSERT INTO "+BaseDeDatos.Turno.TABLE_NAME+" (ID_USUARIO, NOMBRE_TURNO, ID_SERVICIO) VALUES("+
                    run+", "+nombreSucursal+", "+servicioSucursal+")");*/
            values.put("ID_USUARIO", run);
            values.put("NOMBRE_TURNO", nombreSucursal);
            values.put("ID_SERVICIO", servicioSucursal);
            db.insert(BaseDeDatos.Turno.TABLE_NAME, null, values);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
