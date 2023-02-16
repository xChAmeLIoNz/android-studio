package com.iseppe.app08.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.iseppe.app08.R;
import com.iseppe.app08.model.Promemoria;
import com.iseppe.app08.service.Database;

import java.util.Date;
import java.util.GregorianCalendar;

public class PromemoriaActivity extends AppCompatActivity {

    private Date dataSelezionata = new Date();
    private boolean modo; //true = modifica; false = nuovo
    private Promemoria promemoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promemoria);

        //id componenti
        CalendarView memoData = findViewById(R.id.memo_data);
        EditText memoOggetto = findViewById(R.id.memo_oggetto);
        Button registra = findViewById(R.id.registra);

        //recupero valore passato tramite Intent
        Bundle bundle = getIntent().getExtras();
        modo = bundle.getBoolean("modo", false);

        //pre-istanzazione in caso di modificaù
        if(modo) {

            promemoria = Promemoria.getElenco().get(bundle.getInt("posizione"));
            dataSelezionata = promemoria.getData();
            memoData.setDate(dataSelezionata.getTime());
        }


        Database database = new Database(this);

        //interviene quando l'utente seleziona una data
        memoData.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                dataSelezionata = new GregorianCalendar(i, i1, i2).getTime();
            }
        });

        //evento generato al button registra
        registra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("data", dataSelezionata.toString());
                Promemoria promemoria = new Promemoria(dataSelezionata, memoOggetto.getText().toString());
                database.creaPromemoria(promemoria);

                Intent intent = new Intent(PromemoriaActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }
}