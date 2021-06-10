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

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvListaPlaylist = findViewById(R.id.lista_playlist_recycler_view);
        PlaylistViewModel model = new ViewModelProvider(this).get(PlaylistViewModel.class);
        HttpResponse<String> response = Unirest.get("https://movie-database-imdb-alternative.p.rapidapi.com/?i=tt4154796&r=json")
                .header("x-rapidapi-key", "bc76699347mshc7b99201b5e138dp1c96eejsn68b9da1eb7e0")
                .header("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
                .asString();
        List<Playlist> listaPlaylist = model.playlists;

        ItemPlaylistAdapter adapter = new ItemPlaylistAdapter(listaPlaylist);

        rvListaPlaylist.setAdapter(adapter);

        rvListaPlaylist.setLayoutManager(new LinearLayoutManager(this));

    }
}