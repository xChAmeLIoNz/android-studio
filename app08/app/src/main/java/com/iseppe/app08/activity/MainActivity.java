package com.iseppe.app08.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iseppe.app08.R;
import com.iseppe.app08.adapter.PromemoriaAdapter;
import com.iseppe.app08.service.Database;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView elenco = findViewById(R.id.elenco);
        FloatingActionButton aggiungi = findViewById(R.id.aggiungi);

        new Database(this).leggiPromemoria();
        PromemoriaAdapter adapter = new PromemoriaAdapter(this);
        elenco.setAdapter(adapter);

        //evento al click del button aggiungi
        aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, PromemoriaActivity.class);
                intent.putExtra("modo", false);
                finish();
                startActivity(intent);
            }
        });

       elenco.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               //id componenti e acquisizione id promemoria
               TextView idPromemoria = view.findViewById(R.id.id);
               LinearLayout layoutPulsanti = view.findViewById(R.id.layout_pulsanti);
               ImageView btnModifica = view.findViewById(R.id.btn_modifica);
               ImageView btnCancella = view.findViewById(R.id.btn_cancella);

               //visibilità al layout dei pulsanti
               layoutPulsanti.setVisibility(View.VISIBLE);

               //evento al click su btn cancella
               btnCancella.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       new Database(MainActivity.this)
                               .cancellaPromemoria(Integer.parseInt(idPromemoria.getText().toString()));

                       adapter.notifyDataSetChanged();
                   }
               });

               //evento al click button modifica
               btnModifica.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       Intent intent = new Intent(MainActivity.this, PromemoriaActivity.class);
                       intent.putExtra("modo", true);
                       intent.putExtra("posizione", i);
                       finish();
                       startActivity(intent);
                   }
               });
           }
       });

    }
}