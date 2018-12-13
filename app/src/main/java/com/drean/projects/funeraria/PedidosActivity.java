package com.drean.projects.funeraria;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.drean.projects.funeraria.adapter.AdapterPedido;
import com.drean.projects.funeraria.pojo.Pedido;
import com.drean.projects.funeraria.presenter.RegistroPedido;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {

    private ArrayList<Pedido> pedidos;
    private RecyclerView listapedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_pedidos);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Pedidos");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listapedidos = findViewById(R.id.lista_pedidos);

        datos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void datos() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listapedidos.setLayoutManager(llm);

        inicializar();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        AdapterPedido adaptadorPedido = new AdapterPedido(pedidos, this);
        listapedidos.setAdapter(adaptadorPedido);
    }

    public void inicializar(){
        pedidos = new ArrayList<>();
        RegistroPedido registro = new RegistroPedido(getApplicationContext());
        pedidos = registro.obtenerPedidos();
    }
}
