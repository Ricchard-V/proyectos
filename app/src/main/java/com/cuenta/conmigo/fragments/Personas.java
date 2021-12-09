package com.cuenta.conmigo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.cuenta.conmigo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Personas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Personas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingresos, container, false);
    }
}