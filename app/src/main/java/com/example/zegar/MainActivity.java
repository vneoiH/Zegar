package com.example.zegar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//Napisz aplikacje, w ktorej w glownej aktywnosci bedzie wyswietlony aktualny czas oraz data.
 //Twoim zadaniem jest napisac aplikacje, ktora podczas wyswietlonej aktywnosci bedzie te dane
// odswiezac na biezaco.

public class MainActivity extends Activity {
    TextView text;
    Calendar calendar;
    SimpleDateFormat simpleDataFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        runthread();


    }
    private void runthread() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {           
                        try {
                            calendar = Calendar.getInstance();
                            simpleDataFormat = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
                            text.setText(simpleDataFormat.format(calendar.getTime()));
                            runthread();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        })  ;
    }
}
