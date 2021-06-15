package com.ucsal.listadossonhos.repository;

import com.ucsal.listadossonhos.api.FilmeInterface;
import com.ucsal.listadossonhos.model.FilmeRetorno;
import com.ucsal.listadossonhos.util.Config;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmeRepository {


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Config.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    FilmeInterface service = retrofit.create(FilmeInterface.class);

    public Call<FilmeRetorno> getPopularList() {
        return service.getPopularList(Config.API_KEY, "pt-BR");
    }
}
