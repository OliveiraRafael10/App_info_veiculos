package com.example.info_carros_api.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.info_carros_api.R;
import com.example.info_carros_api.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMarcas = new Intent(MainActivity.this, BuscaInfo.class);
                telaMarcas.putExtra("tipoVeiculo", 1);
                startActivity(telaMarcas);

            }
        });

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMarcas = new Intent(MainActivity.this, BuscaInfo.class);
                telaMarcas.putExtra("tipoVeiculo", 2);
                startActivity(telaMarcas);

            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaMarcas = new Intent(MainActivity.this, BuscaInfo.class);
                telaMarcas.putExtra("tipoVeiculo", 3);
                startActivity(telaMarcas);

            }
        });


    }

}