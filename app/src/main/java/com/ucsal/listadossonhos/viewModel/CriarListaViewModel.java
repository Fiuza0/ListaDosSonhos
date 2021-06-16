package com.ucsal.listadossonhos.viewModel;

import androidx.lifecycle.ViewModel;

import com.ucsal.listadossonhos.model.Filme;
import com.ucsal.listadossonhos.model.FilmeRetorno;
import com.ucsal.listadossonhos.repository.FilmeRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CriarListaViewModel extends ViewModel {
    private FilmeRepository repo = new FilmeRepository();

    public void loadMovies(Callback<FilmeRetorno> filmeCb) {
        Call<FilmeRetorno> call = repo.getPopularList();
        call.enqueue(filmeCb);
    }
}
