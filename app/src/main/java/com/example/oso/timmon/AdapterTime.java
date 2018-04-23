package com.example.oso.timmon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterTime extends RecyclerView.Adapter<AdapterTime.ViewHolder> {
    private ArrayList<String> lista;
    private Context context;
    private int layout;

    public AdapterTime(ArrayList<String> lista, Context context, int layout) {
        this.lista = lista;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String actividad = lista.get(position);
        holder.txtActividad.setText(actividad);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtActividad;
        public ViewHolder(View itemView) {
            super(itemView);
            txtActividad = itemView.findViewById(R.id.text_time_activity);
        }
    }
}
