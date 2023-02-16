package it.corso.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import it.corso.R;
import it.corso.adapter.ContattoAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView elenco = findViewById(R.id.elenco);
        //installazione adpter
        ContattoAdapter adpter = new ContattoAdapter(this);
        //assegnazione adpter a list
        elenco.setAdapter(adpter);
        //rendiamo dinamica la listview
        elenco.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView idView = view.findViewById(R.id.id);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("id_contatto",Integer.parseInt(idView.getText().toString()));
                startActivity(intent);
            }
        });
    }
}