package com.example.monitor;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.net.VpnService;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.monitor.NetworkActivity;
import com.example.monitor.R;
import com.example.monitor.ScanningActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_PERMISSION_CODE = 123;
    private static final String TAG = "PermissionCollector";
    
    
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




    }
}
