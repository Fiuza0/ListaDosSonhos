package com.ucsal.listadossonhos.model;

public class Filme {

    private Integer id;

    private String nome;

    public Integer getId() {
        return id;
    }

    public Filme(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Filme() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
