package it.corso.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import it.corso.R;
import it.corso.model.Contatto;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //identificazione componenti
        TextView contatto_id = findViewById(R.id.contatto_id);
        TextView contatto_nome = findViewById(R.id.contatto_nome);
        TextView contatto_cognome = findViewById(R.id.contatto_cognome);
        TextView contatto_telefono = findViewById(R.id.contatto_telefono);
        //instanziazione oggetto bundle recupero parametro
        Bundle bundle = getIntent().getExtras();
        int identificativo = bundle.getInt("id_contatto");
        // recupero contatto della collezione in base all'identificativo
        Contatto contatto = null;
        for(Contatto c : Contatto.getContatti()){
            if(c.getId() == identificativo){
                contatto = c;
                break;
            }
        }
        contatto_id.setText(String.valueOf(contatto.getId()));
        contatto_nome.setText(String.valueOf(contatto.getNome()));
        contatto_cognome.setText(String.valueOf(contatto.getCognome()));
        contatto_telefono.setText(String.valueOf(contatto.getTelefono()));
    }
}