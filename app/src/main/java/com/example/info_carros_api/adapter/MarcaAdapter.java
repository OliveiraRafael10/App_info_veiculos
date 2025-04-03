package com.example.info_carros_api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
        holder.binding.txtBody.setText(marcaList.get(position).getBrand());
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