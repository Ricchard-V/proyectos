package com.cuenta.conmigo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cuenta.conmigo.GastosVo;
import com.cuenta.conmigo.R;
import com.cuenta.conmigo.adapters.GastosAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.Button;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;


public class Gastos extends Fragment {

    RecyclerView recyclerGastos;
    ArrayList<GastosVo> listGastos;
    GastosAdapter adapterGastos;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    int img;
    //DatabaseReference gastosReference = databaseReference.child("gastos");

    public Gastos() {
        // Required empty public constructor
    }

    private  void startFirebase(){
        FirebaseApp.initializeApp(Gastos.this.getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        startFirebase();
        View vista = inflater.inflate(R.layout.fragment_gastos, container, false);

        listGastos = new ArrayList<>();
        recyclerGastos = vista.findViewById(R.id.Recycler_gastos);
        recyclerGastos.setLayoutManager(new LinearLayoutManager(getContext()));

        datosdb();
        //llenarLista();
        adapterGastos = new GastosAdapter(listGastos);
        recyclerGastos.setAdapter(adapterGastos);

        return vista;
    }

    private void datosdb() {
        databaseReference.child("gastos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listGastos.removeAll(listGastos);
                for(DataSnapshot ds : snapshot.getChildren()){

                        setImagen(Integer.parseInt(ds.child("foto").getValue().toString()));
                        img =  setImagen(Integer.parseInt(ds.child("foto").getValue().toString()));

                    listGastos.add(new GastosVo("1",ds.child("nombre").getValue().toString(),
                                ds.child("descripcion").getValue().toString(),
                                ds.child("fecha").getValue().toString()+" de cada Mes",
                                img,
                                Double.parseDouble(ds.child("fecha").getValue().toString())
                                ));
                }
                adapterGastos.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private int setImagen(int image){
        int icon = R.drawable.foco;

        if(image == 1){
            icon = R.drawable.foco;
        }
        if(image == 2){
            icon = R.drawable.gas;
        }
        if(image == 3){
            icon = R.drawable.gota;
        }

        return icon;
    }
    /*private void llenarLista() {
             (ds.child("id").getValue().toString(),
                            ds.child("id").getValue().toString(),
                            ds.child("id").getValue().toString(),
                            ds.child("id").getValue().toString(),
                            ds.child("id").getValue().toString())


            listGastos.add(new GastosVo("1","Luz","Servicio Publico de la Luz prestado por Codenda","13 de cada Mes",R.drawable.foco,35500));
            listGastos.add(new GastosVo("2","Gas","Servicio Publico del  Gas prestado por Enesa","5 de cada Mes",R.drawable.gas,7600));
    }*/
}