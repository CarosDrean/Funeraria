package com.drean.projects.funeraria;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.drean.projects.funeraria.adapter.AdapterPedido;
import com.drean.projects.funeraria.pojo.Pedido;
import com.drean.projects.funeraria.presenter.RegistroPedido;

import java.util.ArrayList;

public class BuscarActivity extends AppCompatActivity {

    private ArrayList<Pedido> pedidos;
    private RecyclerView listapedidos;
    TextView sinResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_buscar);
        sinResult = findViewById(R.id.sin_resultados);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Buscar Pedidos");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listapedidos = findViewById(R.id.lista_pedidos_dni);

        final EditText edtBuscar = findViewById(R.id.edt_buscar);
        Button buscar = findViewById(R.id.btn_buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = edtBuscar.getText().toString();
                if (!dni.equals("")) {
                    datos(Integer.parseInt(dni));
                }else {
                    datos(0);
                }

            }
        });
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

    public void datos(int dni) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listapedidos.setLayoutManager(llm);

        if(dni == 0) {
            sinResult.setVisibility(View.VISIBLE);
            pedidos = new ArrayList<>();
        } else {
            sinResult.setVisibility(View.INVISIBLE);
            inicializar(dni);
        }

        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        AdapterPedido adaptadorPedido = new AdapterPedido(pedidos, this);
        listapedidos.setAdapter(adaptadorPedido);
    }

    public void inicializar(int dni){
        pedidos = new ArrayList<>();
        RegistroPedido registro = new RegistroPedido(getApplicationContext());
        pedidos = registro.obtenerPedidosDNI(dni);
        if(pedidos.isEmpty()){
            sinResult.setVisibility(View.VISIBLE);
        }
    }
}
