package com.iseppe.app_05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ID componenti
        TextView uno = findViewById(R.id.uno);
        TextView due = findViewById(R.id.due);
        TextView nuova = findViewById(R.id.nuova);

        //visualizzazione primo fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.contenuto, new FragmentUno());
        transaction.commit();
        //evento assegnato alla TextView uno
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiaSezione(view);
            }
        });

        //evento assegnato alla TextView due
        due.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiaSezione(view);
            }
        });
    }
    private void cambiaSezione(View view) {

        Fragment fragment;
        if (view == findViewById(R.id.uno)) {

            fragment = new FragmentUno();

        } else {

            fragment = new FragmentDue();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenuto, fragment);
        transaction.commit();

    }

}