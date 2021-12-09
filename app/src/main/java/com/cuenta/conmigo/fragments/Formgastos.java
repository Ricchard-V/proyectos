package com.cuenta.conmigo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cuenta.conmigo.GastosVo;
import com.cuenta.conmigo.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Formgastos extends Fragment {
        View   view;
        ImageView btnNew;
        ImageView btnUpdate;
        ImageView btnDelete;
        EditText Txtfoto,Txtnombre,Txtdescripcion,Txtvalor,Txtfecha;

        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference;

        GastosVo gastosVo = new GastosVo();
        public Formgastos(){

        }

        private  void startFirebase(){
            FirebaseApp.initializeApp(Formgastos.this.getContext());
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference();
        }

        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle
        savedInstanceState){
            view = inflater.inflate(R.layout.fragment_formgastos, container, false);

            //incio database
            startFirebase();

            //Vinculacion de Objetos_vista
            btnNew = (ImageView) view.findViewById(R.id.btn_formGastos_new);
            btnUpdate = (ImageView) view.findViewById(R.id.btn_formGastos_update);
            btnDelete = (ImageView) view.findViewById(R.id.btn_formGastos_delete);

            //Vinculacion de campos
            Txtfoto = view.findViewById(R.id.spinner_foto);
            Txtnombre = view.findViewById(R.id.txt_formGasto_nombre);
            Txtdescripcion = view.findViewById(R.id.txt_formGasto_descripcion);
            Txtvalor = view.findViewById(R.id.txt_formGasto_valor);
            Txtfecha = view.findViewById(R.id.txt_formGasto_fecha);





            //Guardar
            btnNew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Txtvalor.getText().toString().equals("")){ Txtvalor.setText("0"); }
                    if (Txtfoto.getText().toString().equals("")){ Txtfoto.setText("0"); }

                    Save(Integer.parseInt(Txtfoto.getText().toString()),Txtnombre.getText().toString(),
                            Txtdescripcion.getText().toString(),Double.parseDouble(Txtvalor.getText().toString()),Txtfecha.getText().toString());
                }
            });

            //actualizar funcion save
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Txtvalor.getText().toString().equals("")){ Txtvalor.setText("0"); }
                    if (Txtfoto.getText().toString().equals("")){ Txtfoto.setText("0"); }
                    Save(Integer.parseInt(Txtfoto.getText().toString()),Txtnombre.getText().toString(),
                            Txtdescripcion.getText().toString(),Double.parseDouble(Txtvalor.getText().toString()),Txtfecha.getText().toString());
                }
            });

            //eliminar
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Txtvalor.getText().toString().equals("")){ Txtvalor.setText("0"); }
                    if (Txtfoto.getText().toString().equals("")){ Txtfoto.setText("0"); }
                    Save(Integer.parseInt(Txtfoto.getText().toString()),Txtnombre.getText().toString(),
                            Txtdescripcion.getText().toString(),Double.parseDouble(Txtvalor.getText().toString()),Txtfecha.getText().toString());
                }
            });


            return view;
        }
    //Guarda en base de datos
        public void Save(Integer foto,String nombre,String descripcion,Double valor,String fecha){

            if (validate(foto,nombre,descripcion,valor,fecha)) {
                UUID id = (UUID.randomUUID());
                String setid = String.valueOf(id);
                gastosVo.setId(setid);
                gastosVo.setFoto(foto);
                gastosVo.setNombre(nombre);
                gastosVo.setDescripcion(descripcion);
                gastosVo.setValor(valor);
                gastosVo.setFecha(fecha);

                databaseReference.child("gastos").child(gastosVo.getId()).setValue(gastosVo);

                Toast.makeText(Formgastos.this.getContext(), "Guardado", Toast.LENGTH_LONG).show();
                cleanBox();
            }else{
                Txtfoto.setText("");
                Txtvalor.setText("");
            }

    }



        //limpia cajas
        public void cleanBox(){
            Txtfoto.setText("");
            Txtnombre.setText("");
            Txtdescripcion.setText("");
            Txtvalor.setText("");
            Txtfecha.setText("");
        }
        //Valida textos vacios
        public boolean validate(Integer foto,String nombre,String descripcion,Double valor,String fecha){

            if(foto.equals(0)|| nombre.equals("")||valor.equals(0)|| fecha.equals("")){
                Txtfoto.setError("Campo Requerido");
                Txtnombre.setError("Campo Requerido");
                Txtvalor.setError("Campo Requerido");
                Txtfecha.setError("Campo Requerido");
                return false;
            }else{
                return true;
            }
        }


}