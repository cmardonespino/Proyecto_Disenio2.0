package com.example.carlosandres.turnpass.Controlador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.carlosandres.turnpass.R;

/***************************** R E F E R E N C I A S *******************************/

/* https://developer.android.com/training/basics/firstapp/starting-activity.html */
/* https://stackoverflow.com/questions/6543811/intent-putextra-list */
/* https://developer.android.com/training/custom-views/create-view.html */
/* http://sqlitebrowser.org/ */
/* https://stackoverflow.com/questions/17529766/view-contents-of-database-file-in-android-studio */

/***********************************************************************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void VistaLlenarTablas(View vistaLlenarTablas){
        Intent intent = new Intent(this, LlenarTablas.class);
        startActivity(intent);
    }
}
