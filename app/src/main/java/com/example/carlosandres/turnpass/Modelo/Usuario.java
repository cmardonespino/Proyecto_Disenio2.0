package com.example.carlosandres.turnpass.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by CarlosAndres on 01-11-2017.
 */

public class Usuario extends SQLiteOpenHelper{


    public static class FeedEntry implements BaseColumns {

        /***********************************************************************************************/
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Usuario.db";
        public static final String TABLE_NAME = "Usuario";

        /********************* VARIABLES DEFINIDOS EN DIAGRAMA DE CLASES ***************************/
        public static final String COLUM_USUARIO_NOMBREDEUSUARIO = "NOMBREDEUSUARIO";
        public static final String COLUM_USUARIO_PASSWORD = "PASSWORD";
        public static final String COLUM_USUARIO_DISCAPACIDAD = "DISCAPACIDAD";
        /********************* VARIABLES DEFINIDOS EN EL MODELO RELACIONAL *************************/
        public static final String COLUM_USUARIO_ID = "ID";
        public static final String COLUM_USUARIO_IDDISCAPACIDAD = "IDDISCAPACIDAD";
        public static final String COLUM_USUARIO_IDTURNO = "IDTURNO";
        /************************************************************************************************/

        public static final String CREAR_TABLA =
                "CREATE TABLE " + TABLE_NAME + "(" + COLUM_USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUM_USUARIO_NOMBREDEUSUARIO + " VARCHAR, " + COLUM_USUARIO_PASSWORD + " VARCHAR, " +
                        COLUM_USUARIO_DISCAPACIDAD + " VARCHAR, " + COLUM_USUARIO_IDTURNO + " VARCHAR, " +
                        COLUM_USUARIO_IDDISCAPACIDAD + " VARCHAR)";

        public static final String BORRAR_TABLA =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public Usuario(Context context) {
        super(context, FeedEntry.DATABASE_NAME, null, FeedEntry.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FeedEntry.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
