package com.example.contatti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contatto> {

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Contatto> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Ottiene un oggetto di sistema
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Ottengo un istanza di una riga (basata sul suo xml)
        convertView = inflater.inflate(R.layout.row_layout, null);
        //Ottengo le mie due TextView
        TextView  textViewName = (TextView)convertView.findViewById(R.id.textViewName);
        TextView  textViewNumber = (TextView)convertView.findViewById(R.id.textViewNumber);
        Contatto c = getItem(position);
        textViewName.setText(c.getNome() + " " + c.getCognome());
        textViewNumber.setText(c.getTelefono());
        return convertView;
    }
}
