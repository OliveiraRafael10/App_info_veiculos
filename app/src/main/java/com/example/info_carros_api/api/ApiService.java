package com.example.info_carros_api.api;

import com.example.info_carros_api.model.Marca;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import java.util.List;

public interface ApiService {
    @GET("v1/fipe/brands/{tipo_valor}")
    Call<List<Marca>> getMarcas(
            @Path("tipo_valor") int tipo_valor,
            @Query("token") String token
    );
}
