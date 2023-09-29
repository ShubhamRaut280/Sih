package com.example.monitor.sideloading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monitor.R;

import java.util.List;

public class AdapterForSapps extends RecyclerView.Adapter<HolderForSapps> {
    Context context;
    List<SideloadedApp> items;

    public AdapterForSapps(Context context, List<SideloadedApp> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public HolderForSapps onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderForSapps(LayoutInflater.from(context).inflate(R.layout.sideloaded_apps, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderForSapps holder, int position) {
        holder.name.setText(items.get(position).name);
        holder.img.setImageDrawable(items.get(position).icon);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

