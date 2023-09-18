package com.example.monitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView descr;
        Button net;
        Button scan;

        descr = findViewById(R.id.descr);
        net = findViewById(R.id.gotoNetwork);
        scan = findViewById(R.id.gotoScanning);

        net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent netpage;
                netpage = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(netpage);



            }
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scanpage;
                scanpage = new Intent(MainActivity.this, ScanningActivity.class);
                startActivity(scanpage);
            }
        });



        Button startVpnButton = findViewById(R.id.startVpnButton);
        startVpnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vpnIntent = VpnService.prepare(MainActivity.this);
                if (vpnIntent != null) {
                    startActivityForResult(vpnIntent, 0);
                } else {
                    onActivityResult(0, RESULT_OK, null);
                }
            }
        });



    }
}