package com.example.monitor.sideloading;

import android.graphics.drawable.Drawable;

public class sideApps {
    String name;
    Drawable img;

    public sideApps(String name) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
