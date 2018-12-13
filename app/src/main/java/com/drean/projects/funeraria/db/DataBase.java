package com.drean.projects.funeraria.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.drean.projects.funeraria.pojo.Pedido;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    private Context context;

    public DataBase(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreteTable = "CREATE TABLE " + ConstantesBaseDatos.TABLE_NAME + " ("
                + ConstantesBaseDatos.ID  + " INTEGER PRIMARY KEY, "
                + ConstantesBaseDatos.CAJON + " TEXT, "
                + ConstantesBaseDatos.CAJON_IMG + " TEXT, "
                + ConstantesBaseDatos.CANTIDAD + " TEXT, "
                + ConstantesBaseDatos.CELULAR + " TEXT, "
                + ConstantesBaseDatos.DNI + " TEXT, "
                + ConstantesBaseDatos.EMAIL + " TEXT, "
                + ConstantesBaseDatos.FECHA + " TEXT, "
                + ConstantesBaseDatos.HORA + " TEXT, "
                + ConstantesBaseDatos.IGV + " TEXT, "
                + ConstantesBaseDatos.NOMBRE + " TEXT, "
                + ConstantesBaseDatos.PRECIO_UNIDAD + " TEXT, "
                + ConstantesBaseDatos.TOTAL + " TEXT"
                + ")";

        db.execSQL(queryCreteTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Pedido> obtenerRegistros () {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()) {
            Pedido pedidoActual = new Pedido();
            pedidoActual.setId(registros.getInt(0));
            pedidoActual.setCajon(registros.getString(1));
            pedidoActual.setCajonimg(registros.getString(2));
            pedidoActual.setCantidad(registros.getInt(3));
            pedidoActual.setCelular(registros.getInt(4));
            pedidoActual.setDni(registros.getInt(5));
            pedidoActual.setEmail(registros.getString(6));
            pedidoActual.setFecha(registros.getString(7));
            pedidoActual.setHora(registros.getString(8));
            pedidoActual.setIgv(Double.parseDouble(registros.getString(9)));
            pedidoActual.setNombre(registros.getString(10));
            pedidoActual.setPrecioUnidad(Double.parseDouble(registros.getString(11)));
            pedidoActual.setTotal(Double.parseDouble(registros.getString(12)));

            pedidos.add(pedidoActual);
        }
        db.close();
        return pedidos;
    }

    public void ingresarPedido (ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_NAME, null, contentValues);
        db.close();
    }

    public void actualizarCampo(ContentValues contentValues, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBaseDatos.TABLE_NAME, contentValues, ConstantesBaseDatos.ID + " = " + id, null);
        db.close();
    }

    public void borraCampo(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ConstantesBaseDatos.TABLE_NAME + " WHERE " + ConstantesBaseDatos.ID + "=" + id);
        db.close();
    }

    public ArrayList<Pedido> buscarDni(int dni) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_NAME + " WHERE " + ConstantesBaseDatos.DNI + "=" + dni;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()) {
            Pedido pedidoActual = new Pedido();
            pedidoActual.setId(registros.getInt(0));
            pedidoActual.setCajon(registros.getString(1));
            pedidoActual.setCajonimg(registros.getString(2));
            pedidoActual.setCantidad(registros.getInt(3));
            pedidoActual.setCelular(registros.getInt(4));
            pedidoActual.setDni(registros.getInt(5));
            pedidoActual.setEmail(registros.getString(6));
            pedidoActual.setFecha(registros.getString(7));
            pedidoActual.setHora(registros.getString(8));
            pedidoActual.setIgv(Double.parseDouble(registros.getString(9)));
            pedidoActual.setNombre(registros.getString(10));
            pedidoActual.setPrecioUnidad(Double.parseDouble(registros.getString(11)));
            pedidoActual.setTotal(Double.parseDouble(registros.getString(12)));

            pedidos.add(pedidoActual);
        }
        db.close();
        return pedidos;
    }

}
