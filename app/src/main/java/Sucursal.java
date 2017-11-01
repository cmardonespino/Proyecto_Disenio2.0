import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CarlosAndres on 01-11-2017.
 */

public class Sucursal extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Sucursal.db";

    /**************************** VARIABLES DEFINIDOS EN DIAGRAMA DE CLASES ************************/
    public static final String nombre_sucursal = "";
    public static final List<String> servicios_sucursal = new ArrayList<String>();
    public static final String direccion_sucursal = "";
    public static final List<Integer> discapacidadesAptasParaSucursal = new ArrayList<Integer>();
    /***********************************************************************************************/

    public Sucursal(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static abstract class DatosTabla implements BaseColumns {
        public static final String TABLE_NAME = "Sucursal";

        /********************* VARIABLES DEFINIDOS EN EL MODELO RELACIONAL *************************/
        public static final String COLUM_SUCURSAL_ID = "idsucursal";
        public static final String COLUM_SUCURSAL_IDSERVICIO = "idservicio";
        public static final String COLUM_SUCURSAL_IDDIRECCION = "iddireccionsucursal";
        public static final String COLUM_SUCURSAL_SERVICIO = "servicio";
        /*******************************************************************************************/

        /************************** VARIABLE PARA CREAR TABLA SUCURSAL *****************************/
        public static final String CREAR_TABLA =
                "CREATE TABLE " + DatosTabla.TABLE_NAME + " ("+ DatosTabla.COLUM_SUCURSAL_ID+
                        " INTEGER PRIMARY KEY, " + DatosTabla.COLUM_SUCURSAL_IDSERVICIO+
                        " INTEGER, "+ DatosTabla.COLUM_SUCURSAL_IDDIRECCION+
                        " INTEGER, "+ nombre_sucursal+
                        " TEXT, "+ DatosTabla.COLUM_SUCURSAL_SERVICIO+
                        " TEXT)";
        /*******************************************************************************************/

        /************************* VARIABLE PARA BORRAR TABLA **************************************/
        public static final String BORRAR_TABLA =
                "DROP TABLE IF EXISTS +"+DatosTabla.TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatosTabla.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //onUpgrade(sqLiteDatabase, i, i1);
        sqLiteDatabase.execSQL(DatosTabla.BORRAR_TABLA);
        onCreate(sqLiteDatabase);
    }

    public void onDelete(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(DatosTabla.BORRAR_TABLA);
    }
}
