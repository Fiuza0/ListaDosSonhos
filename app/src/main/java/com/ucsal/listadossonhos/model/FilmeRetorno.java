package com.ucsal.listadossonhos.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmeRetorno {
    @SerializedName("results")
    List<Filme> movies;

    public List<Filme> getMovies() {
        return movies;
    }

    public void setMovies(List<Filme> movies) {
        this.movies = movies;
    }
}
