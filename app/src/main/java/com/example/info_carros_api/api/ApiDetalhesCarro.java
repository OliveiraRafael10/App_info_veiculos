package com.example.info_carros_api.api;

import com.example.info_carros_api.model.DetalhesCarro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiDetalhesCarro {
    @GET("v1/fipe/years/{fipe_code}")
    Call <DetalhesCarro> getDetalhesCarro(
            @Path("fipe_code") String fipe_code,
            @Query("token") String token
    );
}
