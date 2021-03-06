package com.ucsal.listadossonhos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.ucsal.listadossonhos.R;
import com.ucsal.listadossonhos.adpter.ItemPlaylistAdapter;
import com.ucsal.listadossonhos.model.Playlist;
import com.ucsal.listadossonhos.repository.PlaylistRepository;
import com.ucsal.listadossonhos.viewModel.CriarListaViewModel;
import com.ucsal.listadossonhos.viewModel.PlaylistViewModel;

import java.util.List;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaylistActivity extends AppCompatActivity {
    ItemPlaylistAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvListaPlaylist = findViewById(R.id.lista_playlist_recycler_view);
        PlaylistViewModel model = new ViewModelProvider(this).get(PlaylistViewModel.class);
        adapter = new ItemPlaylistAdapter(PlaylistRepository.listaPlaylist,id -> {
            Intent intent = new Intent(getApplicationContext(),CriarListaActivity.class);
            intent.putExtra("idPlaylist",id);
            startActivity(intent);
            return null;
        });

        rvListaPlaylist.setAdapter(adapter);

        rvListaPlaylist.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab_add_playlist);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CriarListaActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(adapter != null){
            adapter.notifyDataSetChanged();
        }
    }
}