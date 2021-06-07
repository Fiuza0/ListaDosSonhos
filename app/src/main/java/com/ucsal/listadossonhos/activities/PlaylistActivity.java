package com.ucsal.listadossonhos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ucsal.listadossonhos.R;
import com.ucsal.listadossonhos.adpter.ItemPlaylistAdapter;
import com.ucsal.listadossonhos.model.Playlist;
import com.ucsal.listadossonhos.repository.PlaylistRepository;
import com.ucsal.listadossonhos.viewModel.PlaylistViewModel;

import java.util.List;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.lista_playlist_recycler_view);
        PlaylistViewModel model = new ViewModelProvider(this).get(PlaylistViewModel.class);

        List<Playlist> listaPlaylist = model.playlists;

        ItemPlaylistAdapter adapter = new ItemPlaylistAdapter(listaPlaylist);

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(this));

    }
}