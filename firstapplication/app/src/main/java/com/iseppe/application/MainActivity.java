package com.iseppe.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id dei componenti
         EditText input = findViewById(R.id.input);
         Button btn = findViewById(R.id.btn);
         TextView output = findViewById(R.id.output);

         //impostazioni evento al btn

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //input utente
                String testo = input.getText().toString();
                if(!testo.isEmpty()) {
                    output.setText(testo);
                }
            }
        });
    }
}