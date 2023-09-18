package com.example.monitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        TextView start;
        start = findViewById(R.id.cardsText);
        
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the device is connected to a network
                if (NetUtil.isNetworkConnected(getApplicationContext())) {
                    // The device is connected to a network
                } else {
                    // The device is not connected to a network
                    Toast.makeText(NetworkActivity.this, "You are offline!!", Toast.LENGTH_SHORT).show();
                }

                Intent startvpn;
                startvpn = new Intent(NetworkActivity.this, MyVpnService.class);
                startService(startvpn);

            }
        });
        
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