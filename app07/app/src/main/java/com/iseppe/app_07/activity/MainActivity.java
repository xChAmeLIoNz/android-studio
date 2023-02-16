package com.iseppe.app_07.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.iseppe.app_07.R;
import com.iseppe.app_07.model.Indirizzo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //individuazione componenti
        EditText via = findViewById(R.id.via);
        Spinner provincia = findViewById(R.id.provincia);
        Button registra = findViewById(R.id.registra);
        TextView output = findViewById(R.id.output);
        Button leggi = findViewById(R.id.leggi);
        TextView letto = findViewById(R.id.letto);

        //dichiarazione e istanziazione ArrayAdapter per spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.province)
        );
        //assegnazione adapter a spinner
        provincia.setAdapter(adapter);

        //evento al click del button registra
        registra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registraIndirizzo(via.getText().toString(), provincia.getSelectedItem().toString(), output);
            }
        });

        //evento al click button leggi
        leggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Indirizzo indirizzo = leggiIndirizzoDaFile();
                if (indirizzo != null) {
                    letto.setText(indirizzo.toString());
                } else {
                    Toast.makeText(MainActivity.this, "Rilevato un problema", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    //metodo per registrare indirizzo
    private void registraIndirizzo(String via, String provincia, TextView output) {

        Indirizzo indirizzo = new Indirizzo(via, provincia);
        Log.i("indirizzo", indirizzo.toString());
        output.setText(indirizzo.toString());
        salvaIndirizzoInFile(indirizzo);
    }

    //metodo per salvare dati indirizzo su file
    private void salvaIndirizzoInFile(Indirizzo indirizzo) {

        try {
            FileOutputStream stream = openFileOutput("indirizzo", MODE_APPEND);
            String testo = indirizzo.getVia() + "," + indirizzo.getProvincia();
            stream.write(testo.getBytes());
            stream.close();
            Toast.makeText(this, "Indirizzo salvato", Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            Toast.makeText(this, "Indirizzo salvato", Toast.LENGTH_LONG).show();
        }
    }

    //metodo per leggere dati indirizzo da file
    private Indirizzo leggiIndirizzoDaFile() {

        try {
            FileInputStream stream = openFileInput("indirizzo");
            int dato;
            String testo = "";

            while ((dato = stream.read()) != -1) {
                testo += (char) dato;
            }
            String[] array = testo.split(",");
            return new Indirizzo(array[0], array[1]);
        } catch (IOException e) {
            return null;
        }
    }
}