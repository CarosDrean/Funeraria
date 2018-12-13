package com.drean.projects.funeraria.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.drean.projects.funeraria.PedidoActivity;
import com.drean.projects.funeraria.PedidosActivity;
import com.drean.projects.funeraria.R;
import com.drean.projects.funeraria.pojo.Pedido;
import com.drean.projects.funeraria.presenter.RegistroPedido;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterPedido extends RecyclerView.Adapter<AdapterPedido.PedidoViewHolder> {

    private ArrayList<Pedido> pedidos;
    private Activity activity;

    public AdapterPedido(ArrayList<Pedido> pedidos, Activity activity) {
        this.pedidos = pedidos;
        this.activity = activity;
    }

    @Override
    public PedidoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido, parent, false);
        return new PedidoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PedidoViewHolder pedidoViewHolder, final int position) {

        final Pedido pedido = pedidos.get(position);
        pedidoViewHolder.titulo.setText(pedido.getNombre());
        pedidoViewHolder.subTitulo.setText(pedido.getCajon());
        Glide.with(activity).load(Integer.parseInt(pedido.getCajonimg())).into(pedidoViewHolder.perfil);

        pedidoViewHolder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, PedidoActivity.class);
                i.putExtra("id", pedido.getId());
                i.putExtra("portada", pedido.getCajonimg());
                i.putExtra("cajon", pedido.getCajon());
                i.putExtra("cajonimg", pedido.getCajonimg());
                i.putExtra("total", pedido.getTotal());
                i.putExtra("precio", pedido.getPrecioUnidad());
                i.putExtra("nombre", pedido.getNombre());
                i.putExtra("igv", pedido.getIgv());
                i.putExtra("email", pedido.getEmail());
                i.putExtra("dni", pedido.getDni());
                i.putExtra("celular", pedido.getCelular());
                i.putExtra("cantidad", pedido.getCantidad());

                // aqui pasar todos los datos y reemplazar en la otra actividad
                activity.startActivity(i);
            }
        });

        pedidoViewHolder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistroPedido registro = new RegistroPedido(activity);
                registro.eliminarPedido(pedido.getId());
                pedidos.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(activity, "¡Pedido Eliminado!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    public static class PedidoViewHolder extends RecyclerView.ViewHolder{

        private TextView titulo;
        private TextView subTitulo;
        private CircleImageView perfil;
        private ImageView editar;
        private ImageView eliminar;

        public PedidoViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.nombre_pedido);
            subTitulo = itemView.findViewById(R.id.nombre_cajon);
            perfil = itemView.findViewById(R.id.iv_pedido);
            editar = itemView.findViewById(R.id.editar);
            eliminar = itemView.findViewById(R.id.eliminar);
        }
    }

}