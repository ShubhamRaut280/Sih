package com.example.monitor.sideloading;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monitor.R;

public class HolderForSapps extends RecyclerView.ViewHolder {

        TextView name;
        ImageView img;





    public HolderForSapps(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.img);
        name = itemView.findViewById(R.id.name);
}

}
