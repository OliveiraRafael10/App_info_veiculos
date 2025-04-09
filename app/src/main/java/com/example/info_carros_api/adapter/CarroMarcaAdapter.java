package com.example.info_carros_api.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.info_carros_api.activitys.TelaCarros;
import com.example.info_carros_api.activitys.TelaDetalhesCarro;
import com.example.info_carros_api.databinding.PostCarroBinding;
import com.example.info_carros_api.model.CarroMarca;

import java.util.ArrayList;

public class CarroMarcaAdapter extends RecyclerView.Adapter<CarroMarcaAdapter.CarroMarcaViewHolder>{

    private final ArrayList<CarroMarca> carroList;
    private final Context context;

    public CarroMarcaAdapter(ArrayList<CarroMarca> carroList, Context context) {
        this.carroList = carroList;
        this.context = context;
    }


    @NonNull
    @Override
    public CarroMarcaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostCarroBinding carroMarcaItem;
        carroMarcaItem = PostCarroBinding.inflate(LayoutInflater.from(context), parent, false);
        return new CarroMarcaViewHolder(carroMarcaItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CarroMarcaViewHolder holder, int position) {
        CarroMarca carro = carroList.get(position);
        holder.binding.btn.setText(carro.getModel());
        holder.binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém o contexto a partir da view
                Context context = v.getContext();
                // Cria uma Intent para iniciar a nova Activity
                Intent intent = new Intent(context, TelaDetalhesCarro.class);
                // Passa dados adicionais, se necessário
                intent.putExtra("fipe_code", carro.getFipe_code());
                // Inicia a nova Activity
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return carroList.size();
    }

    public static class CarroMarcaViewHolder extends RecyclerView.ViewHolder{

        PostCarroBinding binding;
        public CarroMarcaViewHolder(PostCarroBinding binding ) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}