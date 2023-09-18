package com.example.monitor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder extends RecyclerView.ViewHolder{

    ImageView img;
    TextView name, protocol, sni, status;


    public myViewHolder(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.appimg);
        name = itemView.findViewById(R.id.appname);
        protocol = itemView.findViewById(R.id.protocol);
        sni = itemView.findViewById(R.id.sni);
        status = itemView.findViewById(R.id.status);

    }
}
