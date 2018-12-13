package com.drean.projects.funeraria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.drean.projects.funeraria.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcercaDe extends Fragment {


    public AcercaDe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_acerca_de, container, false);
        CircleImageView logo = v.findViewById(R.id.logo);
        Glide.with(getContext()).load(R.drawable.logoimg).into(logo);
        return v;
    }

}
