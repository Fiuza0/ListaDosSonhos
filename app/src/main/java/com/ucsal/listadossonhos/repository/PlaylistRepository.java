package com.ucsal.listadossonhos.repository;

import com.ucsal.listadossonhos.model.Filme;
import com.ucsal.listadossonhos.model.Playlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistRepository {
    public static final List<Playlist> listaPlaylist= new ArrayList<Playlist>();
    public static List<Playlist> obterPlaylists() {
          return listaPlaylist;

    }
    public static void adicionarPlaylist(Playlist playlist){
        listaPlaylist.add(playlist);
    }
}
