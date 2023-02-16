package it.corso.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import it.corso.R;
import it.corso.model.Contatto;

public class ContattoAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return Contatto.getContatti().size();
    }

    //metodo che deve ritornare il singolo contatto in base alla singola posizione
    @Override
    public Contatto getItem(int i) {
        return Contatto.getContatti().get(i);
    }

    //metodo che deve ritornare un identificativo univoco del Contatto (di sitema)
    @Override
    public long getItemId(int i) {
        return i;
    }

    //metodo invocato per ogni Contatto (predisposizione singolo layout)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //identificazione layout ed elemento nella collezione
        View layout = INFLATER.inflate(R.layout.item,null);
        Contatto contatto = getItem(i);
        //identificazione dei singoli componenti del layout item
        TextView id = layout.findViewById(R.id.id);
        TextView nome = layout.findViewById(R.id.nome);
        TextView telefono = layout.findViewById(R.id.telefono);
        //impostazione valore componenti
        id.setText(String.valueOf(contatto.getId()));
        nome.setText(contatto.getNome() + " " + contatto.getCognome());
        telefono.setText(contatto.getTelefono());
        return layout;
    }

    //costruttore
    public ContattoAdapter(Context CONTEXT) {
        this.CONTEXT = CONTEXT;
        INFLATER = (LayoutInflater) CONTEXT.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //attributi
    private final Context CONTEXT;
    private final LayoutInflater INFLATER;

}
