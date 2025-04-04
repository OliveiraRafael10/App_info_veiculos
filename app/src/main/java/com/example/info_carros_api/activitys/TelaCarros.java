package com.example.info_carros_api.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.info_carros_api.RetrofitClient;
import com.example.info_carros_api.adapter.CarroMarcaAdapter;
import com.example.info_carros_api.api.ApiCarroModelo;
import com.example.info_carros_api.databinding.TelaCarrosBinding;
import com.example.info_carros_api.model.CarroMarca;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaCarros extends AppCompatActivity {
    private TelaCarrosBinding binding;
    private CarroMarcaAdapter carroMarcaAdapter;
    private ArrayList<CarroMarca> carroList = new ArrayList<>();
    private String token = "18761|jAArYaQDI03kGWYw4uXdZW9S7ZtFjubj";
    private String idMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TelaCarrosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        idMarca = getIntent().getStringExtra("marcaID");
        ApiCarroModelo api = RetrofitClient.getClient().create(ApiCarroModelo.class);
        api.getCarrosMarca(idMarca, token).enqueue(new Callback<List<CarroMarca>>() {
            @Override
            public void onResponse(Call<List<CarroMarca>> call, Response<List<CarroMarca>> response) {
                if (response.isSuccessful()){
                    ArrayList<CarroMarca> carroMarcas = (ArrayList<CarroMarca>) response.body();
                    if (carroMarcas != null){
                        for (CarroMarca carro: carroMarcas){
                            String code_fipe = carro.getFipe_code();
                            String model = carro.getModel();
                            String id = carro.getId();
                            String years = carro.getYears();
                            carroList.add(
                                    new CarroMarca(id, code_fipe, model, years)
                            );
                        }
                    }
                    else {
                        Toast.makeText(TelaCarros.this, "Erro ao buscar os dados", Toast.LENGTH_SHORT).show();
                    }

                    RecyclerView recyclerViewCarroMarca = binding.recyclerViewCarros;
                    recyclerViewCarroMarca.setLayoutManager(new LinearLayoutManager(TelaCarros.this));
                    recyclerViewCarroMarca.setHasFixedSize(true);

                    carroMarcaAdapter = new CarroMarcaAdapter(carroList, TelaCarros.this);
                    recyclerViewCarroMarca.setAdapter(carroMarcaAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<CarroMarca>> call, Throwable t) {
                Toast.makeText(TelaCarros.this, "Erro fatal de servidor", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
