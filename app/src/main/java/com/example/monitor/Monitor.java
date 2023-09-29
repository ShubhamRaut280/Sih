package com.example.monitor;

import android.app.Application;
import android.content.Context;

public class Monitor extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}