package com.example.carlosandres.turnpass.Modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

/**
 * Created by CarlosAndres on 01-11-2017.
 */

public class Servicio{

    String nombre_servicio;

    public Servicio(String nombre_servicio){
        this.nombre_servicio=nombre_servicio;
    }

    public Servicio(){}

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public ArrayList<Servicio> consultarServicio(SQLiteDatabase db, String idservicio){
        ArrayList<Servicio> serv = new ArrayList<Servicio>();
        Cursor rs = db.rawQuery("SELECT * FROM Servicio WHERE ID_SERVICIO='"+idservicio+"'", null);
        if(rs.moveToFirst()){
            do{
                serv.add(new Servicio(rs.getString(1)));
            }while(rs.moveToNext());
        }
        return serv;
    }

}
