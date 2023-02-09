package com.esercitazione_dettaglio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView pulsante = findViewById(R.id.pulsante);
        TextView nomeProdotto = findViewById(R.id.nome_prodotto);

        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Aggiunto al carrello: " + nomeProdotto.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


}