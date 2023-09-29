package com.example.monitor.sideloading;

import static com.example.monitor.Monitor.context;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.Context;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;

import com.example.monitor.ScanningActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class AppChecker {

    private PackageManager packageManager;

    public AppChecker(Context context) {
        packageManager = context.getPackageManager();
    }

    public List<SideloadedApp> getSideloadedApps() {

        List<ApplicationInfo> apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        List<SideloadedApp> sideloadedApps = new ArrayList<>();

        for (ApplicationInfo app : apps) {
            String packageName = app.packageName;
            Drawable icon = app.loadIcon(packageManager);

            if (isAppSideloaded(packageName)) {
                sideloadedApps.add(new SideloadedApp(packageName, icon));
            }
        }

        return sideloadedApps;
    }

    private boolean isAppSideloaded(String packageName) {

        try {
            // Get app info
            ApplicationInfo appInfo = packageManager.getApplicationInfo(packageName, 0);

            // Get app installation location
            String sourceDir = appInfo.sourceDir;

            // Check if app is installed on system partition
            if(!sourceDir.startsWith("/system/")) {
                return true;
            }

        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }

        return false;

    }
}

class SideloadedApp {

    String name;
    Drawable icon;

    public SideloadedApp(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }



}