package com.iseppe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.iseppe.app_03.R;
import com.iseppe.model.Utente;

public class MainActivity extends AppCompatActivity {

    //componenti layout
    private EditText nome,cognome;
    private RadioGroup genere;
    private CheckBox condizioni;
    private ImageView immagine;
    private TextView output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //individuazione componenti
        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        genere = findViewById(R.id.genere);
        condizioni = findViewById(R.id.condizioni);
        immagine = findViewById(R.id.immagine);
        output = findViewById(R.id.output);
        Button registrati = findViewById(R.id.registrati);

        //assegno evento al click del button registrati
        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registraUtente();
            }
        });

    }

    private void registraUtente() {

        //controlla che l'utente abbia compilato i campi e accettato le condizioni

        if (!nome.getText().toString().isEmpty() && !cognome.getText().toString().isEmpty() && condizioni.isChecked()) {

            //ottengo il valore del radioButton selezionato
            String sesso = ((RadioButton) findViewById(genere.getCheckedRadioButtonId())).getText().toString();
            //costruisco l'oggetto utente
            Utente utente = new Utente(nome.getText().toString(), cognome.getText().toString(), sesso);
            //rendo visibile l'immagine
            immagine.setVisibility(View.VISIBLE);
            //passo la rappresentazione testuale dell'utente alla TextView
            output.setText(utente.toString());

        } else {
            //avvisa l'utente del problema
            Toast.makeText(this, "Qualcosa è andato storto", Toast.LENGTH_LONG).show();
        }
    }
}