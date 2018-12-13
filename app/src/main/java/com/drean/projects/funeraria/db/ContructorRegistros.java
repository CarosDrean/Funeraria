package com.drean.projects.funeraria.db;

import android.content.ContentValues;
import android.content.Context;

import com.drean.projects.funeraria.pojo.Pedido;

import java.util.ArrayList;

public class ContructorRegistros {

    private Context context;

    public ContructorRegistros(Context context) {
        this.context = context;
    }

    public ArrayList<Pedido> obtenerDatos() {
        DataBase db = new DataBase(context);
        return db.obtenerRegistros();
    }

    public ArrayList<Pedido> obtenerDatosDni(int dni) {
        DataBase db = new DataBase(context);
        return db.buscarDni(dni);
    }

    public void insertarPedido(Pedido pedido) {
        DataBase db = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.ID, pedido.getId());
        contentValues.put(ConstantesBaseDatos.CAJON, pedido.getCajon());
        contentValues.put(ConstantesBaseDatos.CAJON_IMG, pedido.getCajonimg());
        contentValues.put(ConstantesBaseDatos.CANTIDAD, pedido.getCantidad());
        contentValues.put(ConstantesBaseDatos.CELULAR, pedido.getCelular());
        contentValues.put(ConstantesBaseDatos.DNI, pedido.getDni());
        contentValues.put(ConstantesBaseDatos.EMAIL, pedido.getEmail());
        contentValues.put(ConstantesBaseDatos.FECHA, pedido.getFecha());
        contentValues.put(ConstantesBaseDatos.HORA, pedido.getHora());
        contentValues.put(ConstantesBaseDatos.IGV, pedido.getIgv());
        contentValues.put(ConstantesBaseDatos.NOMBRE, pedido.getNombre());
        contentValues.put(ConstantesBaseDatos.PRECIO_UNIDAD, pedido.getPrecioUnidad());
        contentValues.put(ConstantesBaseDatos.TOTAL, pedido.getTotal());

        db.ingresarPedido(contentValues);
    }

    public void actualizarCampo(Pedido pedido, int id) {
        DataBase db = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.ID, pedido.getId());
        contentValues.put(ConstantesBaseDatos.CAJON, pedido.getCajon());
        contentValues.put(ConstantesBaseDatos.CAJON_IMG, pedido.getCajonimg());
        contentValues.put(ConstantesBaseDatos.CANTIDAD, pedido.getCantidad());
        contentValues.put(ConstantesBaseDatos.CELULAR, pedido.getCelular());
        contentValues.put(ConstantesBaseDatos.DNI, pedido.getDni());
        contentValues.put(ConstantesBaseDatos.EMAIL, pedido.getEmail());
        contentValues.put(ConstantesBaseDatos.FECHA, pedido.getFecha());
        contentValues.put(ConstantesBaseDatos.HORA, pedido.getHora());
        contentValues.put(ConstantesBaseDatos.IGV, pedido.getIgv());
        contentValues.put(ConstantesBaseDatos.NOMBRE, pedido.getNombre());
        contentValues.put(ConstantesBaseDatos.PRECIO_UNIDAD, pedido.getPrecioUnidad());
        contentValues.put(ConstantesBaseDatos.TOTAL, pedido.getTotal());

        db.actualizarCampo(contentValues, id);
    }

    public void eliminarPedido(int id) {
        DataBase db = new DataBase(context);
        db.borraCampo(id);
    }
}
