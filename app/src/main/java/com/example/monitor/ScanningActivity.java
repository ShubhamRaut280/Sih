package com.example.monitor;

import static android.content.ContentValues.TAG;
import static com.example.monitor.MainActivity.REQUEST_PERMISSION_CODE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.monitor.sideloading.AdapterForSapps;
import com.example.monitor.sideloading.AppChecker;
import com.example.monitor.sideloading.sideApps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScanningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning);
        Button sideloaded = findViewById(R.id.check);

        sideloaded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List Apps = new ArrayList<sideApps>();
                AppChecker appChecker = new AppChecker(ScanningActivity.this);
                Apps = appChecker.getSideloadedApps();



                RecyclerView recyclerView = findViewById(R.id.sideLoadedrecycler);
                recyclerView.setLayoutManager(new LinearLayoutManager(ScanningActivity.this));
                recyclerView.setAdapter(new AdapterForSapps(getApplicationContext(),Apps));
            }
        });

        Button collectButton = findViewById(R.id.collectbutton);
        collectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    new PermissionCollectionTask().execute();
                } else {
                    requestPermission();
                }
            }
        });
    }

    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                new PermissionCollectionTask().execute();
            } else {
                Toast.makeText(this, "Permission denied. Cannot collect permissions.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class PermissionCollectionTask extends AsyncTask<Void, Void, File> {

        @Override
        protected File doInBackground(Void... voids) {
            PackageManager packageManager = getPackageManager();
            List<PackageInfo> packages = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);

            // Get the app-specific directory for file storage
            File storageDir = getExternalFilesDir(null);

            if (storageDir != null) {
                File outputFile = new File(storageDir, "permissions.txt");

                try {
                    FileWriter writer = new FileWriter(outputFile);

                    for (PackageInfo packageInfo : packages) {
                        String[] requestedPermissions = packageInfo.requestedPermissions;
                        if (requestedPermissions != null) {
                            String packageName = packageInfo.packageName;
                            writer.write("Package Name: " + packageName + "\n");

                            for (String permission : requestedPermissions) {
                                try {
                                    PermissionInfo permInfo = packageManager.getPermissionInfo(permission, 0);
                                    String permissionInfo = permInfo.name + ": " + permInfo.protectionLevel + "\n";
                                    writer.write(permissionInfo);
                                } catch (Exception e) {
                                    Log.e(TAG, "Error getting info for " + permission);
                                }
                            }
                        }
                    }

                    writer.close();
                    return outputFile;
                } catch (IOException e) {
                    Log.e(TAG, "Error creating or writing to the file: " + e.getMessage());
                }
            } else {
                Log.e(TAG, "External storage directory is null.");
            }

            return null;
        }

        @Override
        protected void onPostExecute(File outputFile) {
            super.onPostExecute(outputFile);

            if (outputFile != null) {
                Toast.makeText(ScanningActivity.this, "Permissions collected and stored in " + outputFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ScanningActivity.this, "Error collecting permissions.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    }
