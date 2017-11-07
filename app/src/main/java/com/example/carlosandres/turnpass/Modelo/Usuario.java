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

public class Usuario{

    String usuario, password;
    String discapacidad;

    public void solicitarAsignacionTurno(String run, String nombreSucursal, String direccion, String comuna, String servicio){

    }

    public Usuario(){}

    public Usuario(String discapacidad){
        this.discapacidad=discapacidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public ArrayList<Usuario> consultarDiscapacidad(SQLiteDatabase db, String iddiscapacidad){
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        Cursor rs = db.rawQuery("SELECT * FROM Discapacidad WHERE ID='"+iddiscapacidad+"'", null);
        if(rs.moveToFirst()){
            do{
                //nombre_sucursal, servicio, direccion, comuna, discapacidad, modulos
                usuario.add(new Usuario(rs.getString(1)));
            }while(rs.moveToNext());
        }
        return usuario;

    }

    public Cursor solicitarAsignarTurno(SQLiteDatabase db, String run){
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        return db.rawQuery("SELECT * FROM Turno WHERE ID_USUARIO='"+run+"'", null);
    }
}
