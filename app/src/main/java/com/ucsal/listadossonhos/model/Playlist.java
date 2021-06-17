package com.ucsal.listadossonhos.model;

import java.util.List;

public class Playlist {

    private Integer id;
    private List<Filme> filmes;
    private String nome;

    public Playlist(Integer id, List<Filme> filmes, String nome) {
        this.id = id;
        this.filmes = filmes;
        this.nome = nome;
    }

    public Playlist() {
    }

    public Integer getId() {
        return id;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
