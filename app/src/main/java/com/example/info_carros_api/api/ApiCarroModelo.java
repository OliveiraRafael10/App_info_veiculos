package com.example.info_carros_api.api;

import com.example.info_carros_api.model.CarroMarca;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCarroModelo {
    @GET("v1/fipe/models/{marca_id}")
    Call<List<CarroMarca>> getCarrosMarca(
            @Path("marca_id") String marca_id,
            @Query("token") String token
    );
}
