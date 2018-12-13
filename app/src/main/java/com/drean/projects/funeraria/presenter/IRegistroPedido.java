package com.drean.projects.funeraria.presenter;

import com.drean.projects.funeraria.pojo.Pedido;

import java.util.ArrayList;

public interface IRegistroPedido {
    public void ingresarPedido(Pedido pedido);
    public void actualizarPedido(Pedido pedido);
    public ArrayList<Pedido> obtenerPedidos();
    public ArrayList<Pedido> obtenerPedidosDNI(int dni);
    public void eliminarPedido(int id);
}
