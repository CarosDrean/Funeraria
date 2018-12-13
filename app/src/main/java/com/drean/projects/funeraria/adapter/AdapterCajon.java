package com.drean.projects.funeraria.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.drean.projects.funeraria.CajonActivity;
import com.drean.projects.funeraria.R;
import com.drean.projects.funeraria.pojo.Cajon;

import java.util.ArrayList;

public class AdapterCajon extends RecyclerView.Adapter<AdapterCajon.CajonViewHolder> {

    ArrayList<Cajon> cajon;
    Activity activity;

    public AdapterCajon(ArrayList<Cajon> cajon, Activity activity) {
        this.cajon = cajon;
        this.activity = activity;
    }

    @Override
    public CajonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cajon, parent, false);
        return new CajonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CajonViewHolder cajonViewHolder, int position) {
        final Cajon categoria = cajon.get(position);
        cajonViewHolder.cajon.setText(categoria.getCajon());
        Glide.with(activity).load(categoria.getFondo()).into(cajonViewHolder.fondo);

        cajonViewHolder.cajon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, CajonActivity.class);
                i.putExtra("cajon", categoria.getCajon());
                i.putExtra("descripcion", categoria.getDescripcion());
                i.putExtra("precio", categoria.getPrecio());
                i.putExtra("portada", categoria.getFondo());
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cajon.size();
    }

    public static class CajonViewHolder extends RecyclerView.ViewHolder{

        private TextView cajon;
        private ImageView fondo;

        public CajonViewHolder(View itemView) {
            super(itemView);
            cajon = (TextView)itemView.findViewById(R.id.categoria);
            fondo = (ImageView)itemView.findViewById(R.id.fondo_categoria);
        }
    }

}