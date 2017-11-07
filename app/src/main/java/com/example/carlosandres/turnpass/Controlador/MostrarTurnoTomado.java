package com.example.carlosandres.turnpass.Controlador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosandres.turnpass.R;

import java.util.ArrayList;
import java.util.List;

public class MostrarTurnoTomado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> datosIngresados = new ArrayList<String>();
        datosIngresados = getIntent().getStringArrayListExtra("test1");
        //Toast.makeText(getApplicationContext(), datosIngresados.get(0).toString()+" "+datosIngresados.get(1).toString(), Toast.LENGTH_LONG).show();
        //TextView a = (TextView)findViewById(R.id.SuTurno);
        //a.setText(datosIngresados.get(0).toString());
        /*TextView b = (TextView)findViewById(R.id.editTextTiempoEstimado);
        b.setText(datosIngresados.get(1).toString());
        TextView c = (TextView)findViewById(R.id.editTextServicio);
        c.setText(datosIngresados.get(2).toString());
        TextView d = (TextView)findViewById(R.id.editTextNombreSucursal);
        d.setText(datosIngresados.get(3).toString());
        TextView e = (TextView)findViewById(R.id.editTextTurnoDelServicio);
        e.setText(datosIngresados.get(4).toString());*/

        setContentView(R.layout.activity_mostrar_turno_tomado);
    }
}
