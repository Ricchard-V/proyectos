package com.cuenta.conmigo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cuenta.conmigo.GastosVo;
import com.cuenta.conmigo.R;
import com.cuenta.conmigo.adapters.GastosAdapter;

import android.widget.Button;

import java.util.ArrayList;


public class Gastos extends Fragment {

    RecyclerView recyclerGastos;
    ArrayList<GastosVo> listGastos;


    public Gastos() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_gastos, container, false);

        listGastos = new ArrayList<>();
        recyclerGastos = vista.findViewById(R.id.Recycler_gastos);
        recyclerGastos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();
        GastosAdapter adapterGastos = new GastosAdapter(listGastos);
        recyclerGastos.setAdapter(adapterGastos);

        return vista;
    }

    private void llenarLista() {
            listGastos.add(new GastosVo("1","Luz","Servicio Publico de la Luz prestado por Codenda","13 de cada Mes",R.drawable.foco,35500));
            listGastos.add(new GastosVo("2","Gas","Servicio Publico del  Gas prestado por Enesa","5 de cada Mes",R.drawable.gas,7600));
    }
}