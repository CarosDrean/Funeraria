package com.drean.projects.funeraria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.robertlevonyan.views.customfloatingactionbutton.FloatingActionButton;

public class CajonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cajon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getIntent().getStringExtra("cajon"));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab_pedir);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CajonActivity.this, PedidoActivity.class);
                i.putExtra("cajon", getIntent().getStringExtra("cajon"));
                i.putExtra("precio", getIntent().getDoubleExtra("precio", 00.00));
                i.putExtra("portada", getIntent().getIntExtra("portada", R.drawable.atauduno));
                startActivity(i);
            }
        });

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

    private void reemplazar() {
        ImageView portada = findViewById(R.id.portada);
        TextView descripcion = findViewById(R.id.descripcion_cajon);
        TextView precio = findViewById(R.id.precio);
        descripcion.setText(getIntent().getStringExtra("descripcion"));
        precio.setText("S/." + getIntent().getDoubleExtra("precio", 00.00));
        Glide.with(this).load(getIntent().getIntExtra("portada", R.drawable.atauduno)).into(portada);
    }
}
