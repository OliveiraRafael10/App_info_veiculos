package com.example.info_carros_api.activitys;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.info_carros_api.RetrofitClient;
import com.example.info_carros_api.api.ApiDetalhesCarro;
import com.example.info_carros_api.databinding.DetalhesCarroBinding;
import com.example.info_carros_api.model.AnoModelo;
import com.example.info_carros_api.model.DetalhesCarro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaDetalhesCarro extends AppCompatActivity {
    private DetalhesCarroBinding binding;
    private String token = "18761|jAArYaQDI03kGWYw4uXdZW9S7ZtFjubj";
    private String fipe_code;
    private DetalhesCarro detalhesCarro = new DetalhesCarro();
    private List<AnoModelo> years;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DetalhesCarroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fipe_code = getIntent().getStringExtra("fipe_code");
        ApiDetalhesCarro api = RetrofitClient.getClient().create(ApiDetalhesCarro.class);
        api.getDetalhesCarro(fipe_code, token).enqueue(new Callback<DetalhesCarro>() {
            @Override
            public void onResponse(Call<DetalhesCarro> call, Response<DetalhesCarro> response) {
                if (response.isSuccessful() && response.body() != null){
                    detalhesCarro = response.body();
                    binding.txtTitulo.setText(detalhesCarro.getModel());
                    years = detalhesCarro.getYears();
                    AnoModelo modelo = years.get(0);

                    TableLayout tabela = binding.tblDetalhes;
                    TableRow linha_zero = (TableRow) tabela.getChildAt(0);
                    TextView txtFipe = (TextView) linha_zero.getChildAt(1);
                    txtFipe.setText(fipe_code);

                    TableRow linha_um = (TableRow) tabela.getChildAt(1);
                    TextView txtMarca = (TextView) linha_um.getChildAt(1);
                    txtMarca.setText(detalhesCarro.getBrand());

                    TableRow linha_dois = (TableRow) tabela.getChildAt(2);
                    TextView txtReferencia = (TextView) linha_dois.getChildAt(1);
                    txtReferencia.setText(detalhesCarro.getReference());

                    TableRow linha_tres = (TableRow) tabela.getChildAt(3);
                    TextView txtAnoModel = (TextView) linha_tres.getChildAt(1);
                    txtAnoModel.setText(modelo.getModel_year());

                    TableRow linha_quatro = (TableRow) tabela.getChildAt(4);
                    TextView txtCombustivel = (TextView) linha_quatro.getChildAt(1);
                    txtCombustivel.setText(modelo.getFuel());

                    TableRow linha_cinco = (TableRow) tabela.getChildAt(5);
                    TextView txtPreco = (TextView) linha_cinco.getChildAt(1);
                    txtPreco.setText(String.valueOf(modelo.getPrice()));

                }
            }

            @Override
            public void onFailure(Call<DetalhesCarro> call, Throwable t) {
                Toast.makeText(TelaDetalhesCarro.this, "Erro fatal de servidor", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
