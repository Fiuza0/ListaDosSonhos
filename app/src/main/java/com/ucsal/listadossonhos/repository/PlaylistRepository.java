package com.ucsal.listadossonhos.repository;

import com.ucsal.listadossonhos.model.Filme;
import com.ucsal.listadossonhos.model.Playlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistRepository {

    public List<Playlist> obterPlaylists() {

        List<Playlist> aaa = Arrays.asList(new Playlist(1, Arrays.asList(
                new Filme(1, "aaaa"), new Filme(1, "aaaa"), new Filme(1, "aaaa")), "aaa"));
        return aaa;

    }
}
