package com.example.carlosandres.turnpass.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CarlosAndres on 01-11-2017.
 */

public class Sucursal extends SQLiteOpenHelper {

    String nombre_sucursal="";
    int servicio=-1;
    String direccion="";
    boolean dispaciad=false;

    public static class FeedEntry implements BaseColumns {

        /***********************************************************************************************/
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Sucursal.db";
        public static final String TABLE_NAME = "Sucursal";
        /********************* VARIABLES DEFINIDOS EN EL MODELO RELACIONAL *************************/
        public static final String COLUM_SUCURSAL_ID = "ID";
        public static final String COLUM_SUCURSAL_IDSERVICIO = "IDSERVICIO";
        public static final String COLUM_SUCURSAL_NOMBRE = "NOMBRESUCURSAL";
        public static final String COLUM_SUCURSAL_IDDIRECCION = "IDDIRECCION";
        public static final String COLUM_SUCURSAL_IDDISCAPACIDAD = "IDDISCAPACIDAD";
        /*******************************************************************************************/

        public static final String DIRECCION = "";

        public static final String CREAR_TABLA =
                "CREATE TABLE " + TABLE_NAME + "(" + COLUM_SUCURSAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUM_SUCURSAL_IDSERVICIO + " VARCHAR, " + COLUM_SUCURSAL_IDDIRECCION + " VARCHAR, " +
                        COLUM_SUCURSAL_IDDISCAPACIDAD + " VARCHAR, " + COLUM_SUCURSAL_NOMBRE + " VARCHAR)";
        public static final String BORRAR_TABLA =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String CONSULTAR_SUCURSAL_SI_EXISTE =
                "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE " + COLUM_SUCURSAL_NOMBRE + " = '";

        public static final String MOSTRAR_DATOS_TABLA =
                "SELECT * FROM "+TABLE_NAME+" WHERE NOMBRESUCURSAL = '";

        public static int getDatabaseVersion() {
            return DATABASE_VERSION;
        }

        public static String getDatabaseName() {
            return DATABASE_NAME;
        }

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getColumSucursalId() {
            return COLUM_SUCURSAL_ID;
        }

        public static String getColumSucursalIdservicio() {
            return COLUM_SUCURSAL_IDSERVICIO;
        }

        public static String getColumSucursalNombre() {
            return COLUM_SUCURSAL_NOMBRE;
        }

        public static String getColumSucursalIddireccion() {
            return COLUM_SUCURSAL_IDDIRECCION;
        }

        public static String getColumSucursalIddiscapacidad() {
            return COLUM_SUCURSAL_IDDISCAPACIDAD;
        }

        public static String getDIRECCION() {
            return DIRECCION;
        }

        public static String getCrearTabla() {
            return CREAR_TABLA;
        }

        public static String getBorrarTabla() {
            return BORRAR_TABLA;
        }

        public static String getConsultarSucursalSiExiste() {
            return CONSULTAR_SUCURSAL_SI_EXISTE;
        }

        public static String getMostrarDatosTabla() {
            return MOSTRAR_DATOS_TABLA;
        }
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isDispaciad() {
        return dispaciad;
    }

    public void setDispaciad(boolean dispaciad) {
        this.dispaciad = dispaciad;
    }

    public Sucursal(Context context) {
        super(context, FeedEntry.DATABASE_NAME, null, FeedEntry.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FeedEntry.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade(sqLiteDatabase, i, i1);
        db.execSQL(FeedEntry.BORRAR_TABLA);
        onCreate(db);
    }

    public Cursor verificarSiExisteSucursal(SQLiteDatabase db, String nombre){
        return db.rawQuery(FeedEntry.CONSULTAR_SUCURSAL_SI_EXISTE+nombre+"'", null);
    }

    public Cursor mostrarDatos(SQLiteDatabase db, String nombre){
        return db.rawQuery(FeedEntry.MOSTRAR_DATOS_TABLA+nombre+"'", null);
    }

    public boolean verificarSiExistenDatosBaseDeDatos(SQLiteDatabase db){
        try{
            Cursor rs = db.rawQuery("SELECT * FROM "+ FeedEntry.TABLE_NAME, null);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
