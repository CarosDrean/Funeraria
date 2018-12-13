package com.drean.projects.funeraria;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.drean.projects.funeraria.pojo.Pedido;
import com.drean.projects.funeraria.presenter.Auxiliar;
import com.drean.projects.funeraria.presenter.RegistroPedido;
import com.robertlevonyan.views.customfloatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class PedidoActivity extends AppCompatActivity {

    private boolean habilitar = false;
    private boolean actualizar = false;

    Auxiliar aux;
    EditText nombre;
    EditText dni;
    EditText celular;
    EditText email;
    EditText cantidad;
    TextView igv;
    TextView precio;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        actualizar = false;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pedido: " + getIntent().getStringExtra("cajon"));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inicializar();

        if (getIntent().getStringExtra("nombre") != null) {
            recibirData();
        }

        clics();
        reemplazar();
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

    public void inicializar() {
        aux = new Auxiliar();
        nombre = findViewById(R.id.edt_nombre);
        dni = findViewById(R.id.edt_dni);
        celular = findViewById(R.id.edt_celular);
        email = findViewById(R.id.edt_email);
        cantidad = findViewById(R.id.edt_cantidad);
        igv = findViewById(R.id.tv_igv);
        precio = findViewById(R.id.tv_precio);
        total = findViewById(R.id.tv_total);
    }

    public void recibirData() {
        actualizar = true;
        nombre.setText(getIntent().getStringExtra("nombre"));
        dni.setText("" + getIntent().getIntExtra("dni", 0));
        celular.setText("" + getIntent().getIntExtra("celular", 0));
        email.setText(getIntent().getStringExtra("email"));
        cantidad.setText("" + getIntent().getIntExtra("cantidad", 0));
        igv.setText("" + getIntent().getDoubleExtra("igv", 0.0));
        precio.setText("" + getIntent().getDoubleExtra("precio", 0.0));
        total.setText("" + getIntent().getDoubleExtra("total", 0.0));
    }

    public void clics() {
        Button calcular = findViewById(R.id.calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                habilitar = true;
                calcular();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab_pedir);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(habilitar) {
                    if(actualizar) {
                        actualizarDatos();
                    }else {
                        ingresarDatos();
                    }
                    irInicio();
                } else {
                    Toast.makeText(PedidoActivity.this, "¡Llene todos los campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void irInicio() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void calcular() {
        double precio = getIntent().getDoubleExtra("precio", 00.00);

        EditText cant = findViewById(R.id.edt_cantidad);
        int cantidad = Integer.parseInt(cant.getText().toString());
        double subtotal = precio * cantidad;
        double igv = subtotal * 0.18;
        double total = (precio * cantidad) + igv;

        TextView igvTv = findViewById(R.id.tv_igv);
        TextView totalTv = findViewById(R.id.tv_total);

        igvTv.setText("" + igv);
        totalTv.setText("" + total);
    }

    public void ingresarDatos(){
        RegistroPedido registro = new RegistroPedido(getApplicationContext());
        // estos datos son para guardarlos en la bd

        Pedido pedido = new Pedido(
                (int) System.currentTimeMillis(),
                getIntent().getStringExtra("cajon"),
                Integer.toString(getIntent().getIntExtra("portada", R.drawable.atauduno)),
                nombre.getText().toString(),
                Integer.parseInt(dni.getText().toString()),
                Integer.parseInt(celular.getText().toString()),
                email.getText().toString(),
                Integer.parseInt(cantidad.getText().toString()),
                Double.parseDouble(precio.getText().toString()),
                Double.parseDouble(igv.getText().toString()),
                aux.obtenerFecha(),
                "Sin hora",
                Double.parseDouble(total.getText().toString())
        );
        registro.ingresarPedido(pedido);
    }

    public void actualizarDatos(){
        RegistroPedido registro = new RegistroPedido(getApplicationContext());
        // estos datos son para guardarlos en la bd
        // aqui se debe traer el id
        Pedido pedido = new Pedido(
                getIntent().getIntExtra("id", 0),
                getIntent().getStringExtra("cajon"),
                Integer.toString(getIntent().getIntExtra("portada", R.drawable.atauduno)),
                nombre.getText().toString(),
                Integer.parseInt(dni.getText().toString()),
                Integer.parseInt(celular.getText().toString()),
                email.getText().toString(),
                Integer.parseInt(cantidad.getText().toString()),
                Double.parseDouble(precio.getText().toString()),
                Double.parseDouble(igv.getText().toString()),
                aux.obtenerFecha(),
                "Sin hora",
                Double.parseDouble(total.getText().toString())
        );
        registro.actualizarPedido(pedido);
    }

    public void reemplazar() {
        TextView precio = findViewById(R.id.tv_precio);
        precio.setText("" + getIntent().getDoubleExtra("precio", 00.00));
        CircleImageView portada = findViewById(R.id.cajon_pedido);
        Glide.with(this).load(getIntent().getIntExtra("portada", R.drawable.atauduno)).into(portada);
    }

}
