package com.ucsal.listadossonhos.viewModel;

import com.ucsal.listadossonhos.model.Filme;

import java.util.List;

public interface FilmeCallback {
    void quandoFilmeChegar(List<Filme> listaFilme);
}
