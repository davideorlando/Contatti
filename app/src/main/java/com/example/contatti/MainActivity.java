package com.example.contatti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contatto> contatti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listViewDemo);

        contatti = new LinkedList<Contatto>();
        contatti.add(new Contatto(1, "Gino", "Michelini", "0123456"));
        contatti.add(new Contatto(2, "Pino", "Giovannini", "5554433"));
        contatti.add(new Contatto(3, "Ugo", "Fantozzi", "222345"));
        contatti.add(new Contatto(4, "Pina", "Fantozzi", "9998877"));
        contatti.add(new Contatto(5, "PierMatteo", "Semenzara", "0191938343"));

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.row_layout, contatti);

        listView.setAdapter(adapter); //Qui disegna la listView

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Id: " + contatti.get(position).getId(),Toast.LENGTH_LONG).show();
            }
        });
    }
}