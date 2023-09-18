package com.example.monitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        TextView start;
        start = findViewById(R.id.cardsText);

        List items = new ArrayList<Connections>();

        //Dummy for now
        items.add(new Connections("Whatsapp","HTTPS","10.215.173.1:40530","157.24023761:443","beacons.gvt2.com","Active"));
        items.add(new Connections("Whatsapp","HTTPS","10.215.173.1:40530","157.24023761:443","beacons.gvt2.com","Active"));
        items.add(new Connections("Whatsapp","HTTPS","10.215.173.1:40530","157.24023761:443","beacons.gvt2.com","Active"));




        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new myAdapter(getApplicationContext(),items));
    }
}