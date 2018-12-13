package com.drean.projects.funeraria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drean.projects.funeraria.R;
import com.drean.projects.funeraria.adapter.AdapterCajon;
import com.drean.projects.funeraria.pojo.Cajon;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Inicio extends Fragment {

    ArrayList<Cajon> cajon;
    private RecyclerView listacajones;


    public Inicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_inicio, container, false);
        listacajones = (RecyclerView)v.findViewById(R.id.lista_cajones);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listacajones.setLayoutManager(llm);

        inicializar();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador(){
        AdapterCajon adaptadorCajon = new AdapterCajon(cajon, getActivity());
        listacajones.setAdapter(adaptadorCajon);
    }

    public void inicializar(){
        cajon = new ArrayList<>();

        cajon.add(new Cajon(getString(R.string.title_cajon_uno), R.drawable.cajon1, 50.00, getString(R.string.descrip_cajon_uno)));
        cajon.add(new Cajon(getString(R.string.title_cajon_dos), R.drawable.cajon2, 60.00, getString(R.string.descrip_cajon_dos)));
        cajon.add(new Cajon(getString(R.string.title_cajon_tres), R.drawable.cajon3, 70.00, getString(R.string.descrip_cajon_tres)));
        cajon.add(new Cajon(getString(R.string.title_cajon_cuatro), R.drawable.cajon4, 80.00, getString(R.string.descrip_cajon_cuatro)));
        cajon.add(new Cajon(getString(R.string.title_cajon_cinco), R.drawable.cajon5, 90.00, getString(R.string.descrip_cajon_cinco)));
        cajon.add(new Cajon(getString(R.string.title_cajon_seis), R.drawable.cajon6, 100.00, getString(R.string.descrip_cajon_seis)));
        cajon.add(new Cajon(getString(R.string.title_cajon_siete), R.drawable.cajon7, 110.00, getString(R.string.descrip_cajon_siete)));
        cajon.add(new Cajon(getString(R.string.title_cajon_ocho), R.drawable.cajon8, 120.00, getString(R.string.descrip_cajon_ocho)));
    }

}
