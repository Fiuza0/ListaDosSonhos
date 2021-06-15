package com.ucsal.listadossonhos.viewModel;

import com.ucsal.listadossonhos.model.Filme;
import com.ucsal.listadossonhos.model.FilmeRetorno;
import com.ucsal.listadossonhos.repository.FilmeRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmeViewModel {
    List<Filme> listaFilme = new ArrayList<Filme>();
    private FilmeRepository repo = new FilmeRepository();

    public void loadMovies() {
        Call<FilmeRetorno> call = repo.getPopularList();
        call.enqueue(new Callback<FilmeRetorno>() {
            @Override
            public void onResponse(Call<FilmeRetorno> call, Response<FilmeRetorno> response) {
                FilmeRetorno data = response.body();

                if (data != null) {
                    listaFilme = data.getMovies();
                }
            }

            @Override
            public void onFailure(Call<FilmeRetorno> call, Throwable t) {

            }
        });
    }
}
