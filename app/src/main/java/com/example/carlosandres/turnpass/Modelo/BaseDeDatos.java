package com.example.carlosandres.turnpass.Modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.io.File;

/**
 * Created by CarlosAndres on 05-11-2017.
 */

public class BaseDeDatos extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ProyectoDisenio.db";

    public BaseDeDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static abstract class Turno implements BaseColumns {
        /***********************************************************************************************/
        public static final String TABLE_NAME = "Turno";
        /********************* VARIABLES DEFINIDOS EN EL MODELO RELACIONAL *************************/
        public static final String COLUM_TURNO_ID = "ID_TURNO";
        public static final String COLUM_TURNO_IDUSUARIO = "ID_USUARIO";
        public static final String COLUM_TURNO_NOMBRE = "NOMBRE_TURNO";
        public static final String COLUM_TURNO_IDSERVICIO = "ID_SERVICIO";
        /*******************************************************************************************/

        public static final String CREAR_TABLA =
                "CREATE TABLE "+ TABLE_NAME+" ("+ COLUM_TURNO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        COLUM_TURNO_IDSERVICIO+ " VARCHAR, "+COLUM_TURNO_IDUSUARIO+" VARCHAR, "+
                        COLUM_TURNO_NOMBRE+" VARCHAR)";
    }

    public static abstract class Servicio implements BaseColumns {
        /***********************************************************************************************/
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "ProyectoDisenio.db";
        public static final String TABLE_NAME = "Servicio";
        /********************* VARIABLES DEFINIDOS EN EL MODELO RELACIONAL *************************/
        public static final String COLUM_SERVICIO_ID = "ID_SERVICIO";
        public static final String COLUM_SERVICIO_NOMBRE = "NOMBRE_SERVICIO";

        public static final String CREAR_TABLA =
                "CREATE TABLE " + TABLE_NAME + " (" + COLUM_SERVICIO_ID + " INTEGER PRIMARY KEY, "
                        + COLUM_SERVICIO_NOMBRE + " VARCHAR)";
    }

    public static class Sucursal implements BaseColumns {

        /***********************************************************************************************/
        public static final String TABLE_NAME = "Sucursal";
        /********************* VARIABLES DEFINIDOS EN EL MODELO RELACIONAL *************************/
        public static final String COLUM_SUCURSAL_ID = "ID_SUCURSAL";
        public static final String COLUM_SUCURSAL_IDSERVICIO = "ID_SERVICIO";
        public static final String COLUM_SUCURSAL_NOMBRE = "NOMBRE_SUCURSAL";
        public static final String COLUM_SUCURSAL_IDDISCAPACIDAD = "ID_DISCAPACIDAD";
        public static final String COLUM_SUCURSAL_DIRECCION = "DIRECCION";
        public static final String COLUM_SUCURSAL_COMUNA = "COMUNA";
        /*******************************************************************************************/

        public static final String DIRECCION = "";

        public static final String CREAR_TABLA =
                "CREATE TABLE " + TABLE_NAME + "(" + COLUM_SUCURSAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUM_SUCURSAL_IDSERVICIO + " VARCHAR, " + COLUM_SUCURSAL_IDDISCAPACIDAD + " VARCHAR, " +
                        COLUM_SUCURSAL_NOMBRE + " VARCHAR, " + COLUM_SUCURSAL_DIRECCION + " VARCHAR, " +
                        COLUM_SUCURSAL_COMUNA + " VARCHAR)";
        public static final String BORRAR_TABLA =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String CONSULTAR_SUCURSAL_SI_EXISTE =
                "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE " + COLUM_SUCURSAL_NOMBRE + " = '";

        public static final String MOSTRAR_DATOS_TABLA =
                "SELECT * FROM "+TABLE_NAME+" WHERE DIRECCION = '";
    }

    public static class Usuario implements BaseColumns {

        /***********************************************************************************************/
        public static final String TABLE_NAME = "Usuario";

        /********************* VARIABLES DEFINIDOS EN DIAGRAMA DE CLASES ***************************/
        public static final String COLUM_USUARIO_ID = "ID";
        public static final String COLUM_USUARIO_NOMBRECOMPLETO = "NOMBRE_COMPLETO";
        public static final String COLUM_USUARIO_EDAD = "EDAD";
        public static final String COLUM_USUARIO_NOMBREDEUSUARIO = "NOMBRE_USUARIO";
        public static final String COLUM_USUARIO_CONTRASENIA = "CONTRASENIA";
        public static final String COLUM_USUARIO_TELEFONO = "TELEFONO";
        public static final String COLUM_USUARIO_DISCAPACIDAD = "ID_DISCAPACIDAD";
        public static final String COLUM_USUARIO_IDTURNO = "ID_TURNO";
        /************************************************************************************************/

        public static final String CREAR_TABLA =
                "CREATE TABLE " + TABLE_NAME + "(" + COLUM_USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUM_USUARIO_NOMBRECOMPLETO + " VARCHAR, " + COLUM_USUARIO_EDAD + " INTEGER, " +
                        COLUM_USUARIO_NOMBREDEUSUARIO + " VARCHAR, " + COLUM_USUARIO_CONTRASENIA + " VARCHAR, " +
                        COLUM_USUARIO_TELEFONO + " VARCHAR, "+COLUM_USUARIO_DISCAPACIDAD+" VARCHAR, "+
                        COLUM_USUARIO_IDTURNO+" VARCHAR)";

        public static final String BORRAR_TABLA =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Sucursal.CREAR_TABLA);
        db.execSQL(Servicio.CREAR_TABLA);
        db.execSQL(Turno.CREAR_TABLA);
        db.execSQL(Usuario.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /*
    public Cursor mostrarDatos(SQLiteDatabase db, String comuna, String direccion){
        return db.rawQuery(Sucursal.MOSTRAR_DATOS_TABLA+direccion+"' AND COMUNA='"+
                comuna+"'", null);
    }*/

    public boolean verificarSiExistenDatosBaseDeDatos(SQLiteDatabase db){
        try{
            //Cursor rs = db.rawQuery("CHECK IF "+ DATABASE_NAME+" EXISTS", null);
            db = SQLiteDatabase.openDatabase("/data/data/com.example.carlosandres.turnpass/databases/ProyectoDisenio.db", null, SQLiteDatabase.OPEN_READONLY);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /* https://stackoverflow.com/questions/3386667/query-if-android-database-exists */
    public static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
}
