package com.example.oso.timmon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oso.timmon.data.model.Actividad;

import java.util.ArrayList;

public class AdapterActividad extends RecyclerView.Adapter<AdapterActividad.ViewHolder> {

    private ArrayList<Actividad> lista;
    private Context context;
    private int layout;
    private OnChangeFragment onChangeFragment;

    public AdapterActividad(ArrayList<Actividad> lista, Context context, int layout) {
        this.lista = lista;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Actividad temp = lista.get(position);
        if (temp.getEsRutina())
            holder.rutina.setVisibility(View.VISIBLE);
        else
            holder.rutina.setVisibility(View.INVISIBLE);
        if (temp.getEstadoActividad())
            holder.imgPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_pause_circle));
        else
            holder.imgPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_play_circle));
        holder.nombre.setText(temp.getNombreActividad());
        holder.imgPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp.getEstadoActividad()) {
                    holder.imgPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_pause_circle));
                    temp.setEstadoActividad(false);
                } else {
                    holder.imgPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_play_circle));
                    temp.setEstadoActividad(true);
                    if (onChangeFragment != null){
                        onChangeFragment.changeFragment();
                    }
                }
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
        holder.color.setBackgroundColor(temp.getColor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "en desarrollo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setOnChangeFragment(OnChangeFragment onChangeFragment){
        this.onChangeFragment = onChangeFragment;
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView tiempo;
        TextView ultimoTiempo;
        ImageButton imgPlayPause;
        ImageView rutina;
        View color;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_actividad_item);
            tiempo = itemView.findViewById(R.id.tiempo_item);
            ultimoTiempo = itemView.findViewById(R.id.tiempo_ultima_vez_item);
            imgPlayPause = itemView.findViewById(R.id.btn_play_pause_item);
            rutina = itemView.findViewById(R.id.icon_rutina_item);
            color = itemView.findViewById(R.id.color_actividad_item);
        }
    }

    interface OnChangeFragment{
        void changeFragment();
    }
}
