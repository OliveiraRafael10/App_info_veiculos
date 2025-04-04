package com.example.info_carros_api.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.info_carros_api.activitys.TelaCarros;
import com.example.info_carros_api.databinding.PostMarcaBinding;
import com.example.info_carros_api.model.Marca;
import java.util.ArrayList;

public class MarcaAdapter extends RecyclerView.Adapter<MarcaAdapter.MarcaViewHolder>{

    private final ArrayList<Marca> marcaList;
    private final Context context;

    public MarcaAdapter(ArrayList<Marca> marcaList, Context context) {
        this.marcaList = marcaList;
        this.context = context;
    }


    @NonNull
    @Override
    public MarcaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostMarcaBinding marcaItem;
        marcaItem = PostMarcaBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MarcaViewHolder(marcaItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MarcaViewHolder holder, int position) {
        Marca marca = marcaList.get(position);
        holder.binding.btn.setText(marca.getBrand());
        holder.binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém o contexto a partir da view
                Context context = v.getContext();
                // Cria uma Intent para iniciar a nova Activity
                Intent intent = new Intent(context, TelaCarros.class);
                // Passa dados adicionais, se necessário
                intent.putExtra("marcaID", marca.getId());
                // Inicia a nova Activity
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return marcaList.size();
    }

    public static class MarcaViewHolder extends RecyclerView.ViewHolder{

        PostMarcaBinding binding;
        public MarcaViewHolder(PostMarcaBinding binding ) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}