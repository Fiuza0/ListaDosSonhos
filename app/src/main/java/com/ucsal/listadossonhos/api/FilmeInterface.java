package com.ucsal.listadossonhos.api;

import com.ucsal.listadossonhos.model.FilmeRetorno;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeInterface {
    @GET("movie/popular")
    Call<FilmeRetorno> getPopularList(
            @Query("api_key") String apiKey,
            @Query("language") String language

    );
}
