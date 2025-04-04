package com.example.info_carros_api.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.info_carros_api.api.ApiService;
import com.example.info_carros_api.model.Marca;
import com.example.info_carros_api.adapter.MarcaAdapter;
import com.example.info_carros_api.RetrofitClient;
import com.example.info_carros_api.databinding.BuscaInfoBinding;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscaInfo extends AppCompatActivity {
    private BuscaInfoBinding binding;
    private MarcaAdapter marcaAdapter;
    private final ArrayList<Marca> marcaList = new ArrayList<>();
    private int valorVeiculo;
    private String token = "18761|jAArYaQDI03kGWYw4uXdZW9S7ZtFjubj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BuscaInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        valorVeiculo = getIntent().getIntExtra("tipoVeiculo", 0);
        ApiService api = RetrofitClient.getClient().create(ApiService.class);
        api.getMarcas(valorVeiculo, token).enqueue(new Callback<List<Marca>>() {
            @Override
            public void onResponse(Call<List<Marca>> call, Response<List<Marca>> response) {
                if (response.isSuccessful()){
                    ArrayList<Marca> marcas = (ArrayList<Marca>) response.body();
                    if(marcas != null){
                        for (Marca marca: marcas){
                            String id = marca.getId();
                            String brand = marca.getBrand();
                            marcaList.add(
                                    new Marca(id, brand)
                            );
                        }
                    }else{
                        Toast.makeText(BuscaInfo.this,"Erro ao buscar os dados",Toast.LENGTH_SHORT).show();
                    }

                    RecyclerView recyclerViewMarcas = binding.recyclerViewMarcas;
                    recyclerViewMarcas.setLayoutManager(new LinearLayoutManager(BuscaInfo.this));
                    recyclerViewMarcas.setHasFixedSize(true);

                    marcaAdapter = new MarcaAdapter(marcaList, BuscaInfo.this);
                    recyclerViewMarcas.setAdapter(marcaAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Marca>> call, Throwable t) {
                Toast.makeText(BuscaInfo.this,"Erro fatal de servidor",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
