package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String STATE_SCORE_1 ="puntuacion 1" ;
    static final String STATE_SCORE_2 ="puntuacion 2";
    private int contadorGoles1 = 0;
    private int contadorGoles2 = 0;
    private TextView contadorEquipo1;
    private TextView contadorEquipo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contadorEquipo1=findViewById(R.id.goles1);
        contadorEquipo2=findViewById(R.id.goles2);
        if (savedInstanceState != null) {
            contadorGoles1 = savedInstanceState.getInt(STATE_SCORE_1);
            contadorGoles2 = savedInstanceState.getInt(STATE_SCORE_2);
            contadorEquipo1.setText(String.valueOf(contadorGoles1));
            contadorEquipo2.setText(String.valueOf(contadorGoles2));
        }else{
             contadorEquipo1.setText(String.valueOf(contadorGoles1));
             contadorEquipo2.setText(String.valueOf(contadorGoles2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, contadorGoles1);
        outState.putInt(STATE_SCORE_2, contadorGoles2);
        super.onSaveInstanceState(outState);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        recreate();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;

    }

    public void incrementar(View view){
        contadorGoles1++;
        /**contadorEquipo1.setText(Integer.toString(contadorGoles1));*/
        contadorEquipo1.setText(String.valueOf(contadorGoles1));
    }

    public void incrementar2(View view){
        contadorGoles2++;
        contadorEquipo2.setText(String.valueOf(contadorGoles2));
    }

    public void decrementar(View view){
        if(contadorGoles1!=0){
            contadorGoles1--;
        }
        contadorEquipo1.setText(String.valueOf(contadorGoles1));
    }

    public void decrementar2(View view){
        if(contadorGoles2!=0){
            contadorGoles2--;
        }
        contadorEquipo2.setText(String.valueOf(contadorGoles2));
    }
}
