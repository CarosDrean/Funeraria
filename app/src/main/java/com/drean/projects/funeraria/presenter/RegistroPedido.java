package com.drean.projects.funeraria.presenter;

import android.content.Context;

import com.drean.projects.funeraria.db.ContructorRegistros;
import com.drean.projects.funeraria.pojo.Pedido;

import java.util.ArrayList;

public class RegistroPedido implements IRegistroPedido {

    private Context context;
    private ContructorRegistros constructorRegistros;
    private ArrayList<Pedido> pedidos;

    public RegistroPedido(Context context) {
        this.context = context;
    }

    @Override
    public void ingresarPedido(Pedido pedido) {
        constructorRegistros = new ContructorRegistros(context);
        constructorRegistros.insertarPedido(pedido);
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        constructorRegistros = new ContructorRegistros(context);
        constructorRegistros.actualizarCampo(pedido, pedido.getId());
    }

    @Override
    public ArrayList<Pedido> obtenerPedidos() {
        constructorRegistros = new ContructorRegistros(context);
        pedidos = constructorRegistros.obtenerDatos();
        return pedidos;
    }

    @Override
    public ArrayList<Pedido> obtenerPedidosDNI(int dni) {
        constructorRegistros = new ContructorRegistros(context);
        pedidos = constructorRegistros.obtenerDatosDni(dni);
        return pedidos;
    }

    @Override
    public void eliminarPedido(int id) {
        constructorRegistros = new ContructorRegistros(context);
        constructorRegistros.eliminarPedido(id);
    }

}
