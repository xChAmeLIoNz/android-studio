package com.iseppe.app08.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iseppe.app08.R;
import com.iseppe.app08.model.Promemoria;

import java.text.SimpleDateFormat;

public class PromemoriaAdapter extends BaseAdapter {

    //attributi
    private final Context CONTEXT;
    private final LayoutInflater INFLATER;
    private final SimpleDateFormat FORMAT;

    //costruttore

    public PromemoriaAdapter(Context CONTEXT) {
        this.CONTEXT = CONTEXT;
        this.INFLATER = (LayoutInflater) CONTEXT.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    }


    @Override
    public int getCount() {
        return Promemoria.getElenco().size();
    }

    @Override
    public Promemoria getItem(int i) {
        return Promemoria.getElenco().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View layout = INFLATER.inflate(R.layout.item_elenco, null);
        Promemoria promemoria = getItem(i);
        TextView id = layout.findViewById(R.id.id);
        TextView data = layout.findViewById(R.id.data);
        TextView oggetto = layout.findViewById(R.id.oggetto);
        id.setText(String.valueOf(promemoria.getId()));
        data.setText(FORMAT.format(promemoria.getData()));
        oggetto.setText(promemoria.getOggetto());

        return layout;
    }
}
