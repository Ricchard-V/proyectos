package com.cuenta.conmigo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cuenta.conmigo.GastosVo;
import com.cuenta.conmigo.R;

import java.util.ArrayList;

public class GastosAdapter extends RecyclerView.Adapter <GastosAdapter.ViewHolderGastos> {

    ArrayList<GastosVo> listGastos;

    public GastosAdapter(ArrayList<GastosVo> listGastos) {
        this.listGastos = listGastos;
    }

    @NonNull
    @Override
    public ViewHolderGastos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_gastos,null,false);
        return new ViewHolderGastos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGastos holder, int position) {
        holder.gastosNombre.setText(listGastos.get(position).getNombre());
        holder.gastosDescripcion.setText(listGastos.get(position).getDescripcion());
        holder.gastosFecha.setText(listGastos.get(position).getFecha());
        holder.gastosValor.setText(listGastos.get(position).getValor());
        holder.gastosImage.setImageResource(listGastos.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listGastos.size();
    }

    public class ViewHolderGastos extends RecyclerView.ViewHolder {
        TextView gastosNombre;
        TextView gastosDescripcion;
        TextView gastosFecha;
        TextView gastosValor;
        ImageView gastosImage;


        public ViewHolderGastos(@NonNull View itemView) {
            super(itemView);
            gastosDescripcion = (TextView) itemView.findViewById(R.id.deuda_descripcion);
            gastosNombre = (TextView) itemView.findViewById(R.id.deuda_nombre);
            gastosFecha = (TextView) itemView.findViewById(R.id.deuda_fecha);
            gastosValor = (TextView) itemView.findViewById(R.id.deuda_valor);
            gastosImage = (ImageView) itemView.findViewById(R.id.deuda_image);
        }
    }
}
