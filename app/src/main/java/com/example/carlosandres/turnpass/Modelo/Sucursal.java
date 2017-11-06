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

public class Sucursal{

    String nombre_sucursal="";
    String servicio="";
    String direccion="";
    String discapacidad="";
    String comuna ="";
    String modulos="";

    public Sucursal(){}

    public Sucursal(String nombre_sucursal, String servicio, String direccion, String comuna, String discapacidad, String modulos){
        this.nombre_sucursal=nombre_sucursal;
        this.servicio=servicio;
        this.direccion=direccion;
        this.discapacidad=discapacidad;
        this.comuna=comuna;
        this.modulos=modulos;
    }

    public String getModulos() {
        return modulos;
    }

    public void setModulos(String modulos) {
        this.modulos = modulos;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

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

    public ArrayList<Sucursal> capturarDatos(SQLiteDatabase db, String direccion, String comuna){
        ArrayList<Sucursal> sucursal = new ArrayList<Sucursal>();
        Cursor rs = db.rawQuery("SELECT * FROM Sucursal WHERE DIRECCION='"+direccion+"' AND COMUNA='"+comuna+"'", null);
        if(rs.moveToFirst()){
            do{
                //nombre_sucursal, servicio, direccion, comuna, discapacidad, modulos
                sucursal.add(new Sucursal(rs.getString(4), rs.getString(1), rs.getString(5), rs.getString(6), rs.getString(3), rs.getString(2)));
            }while(rs.moveToNext());
        }
        return sucursal;
    }

}
