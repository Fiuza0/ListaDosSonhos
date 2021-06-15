package com.ucsal.listadossonhos.viewModel;

import androidx.lifecycle.ViewModel;

import com.ucsal.listadossonhos.model.Filme;
import com.ucsal.listadossonhos.model.Playlist;
import com.ucsal.listadossonhos.repository.PlaylistRepository;

import java.util.List;

public class PlaylistViewModel extends ViewModel {

    public List<Playlist> playlists;
    public PlaylistRepository repository = new PlaylistRepository();

    public void obterPlaylists(){
        playlists = repository.obterPlaylists();
    }
}
