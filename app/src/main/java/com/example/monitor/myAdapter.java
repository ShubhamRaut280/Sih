package com.example.monitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myViewHolder> {

    Context context;
    List<Connections> items;

    public myAdapter(Context context, List<Connections> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.connection_view, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.name.setText(items.get(position).getAppname());
        holder.protocol.setText(items.get(position).getProtocol());
        holder.sni.setText(items.get(position).getSNI());
        holder.status.setText(items.get(position).getStatus());
        holder.img.setImageResource(items.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
