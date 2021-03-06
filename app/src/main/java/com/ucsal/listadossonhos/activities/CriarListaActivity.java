package com.ucsal.listadossonhos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.ucsal.listadossonhos.R;
import com.ucsal.listadossonhos.adpter.ItemFilmeAdapter;
import com.ucsal.listadossonhos.adpter.ItemPlaylistAdapter;
import com.ucsal.listadossonhos.model.Filme;
import com.ucsal.listadossonhos.model.FilmeRetorno;
import com.ucsal.listadossonhos.model.Playlist;
import com.ucsal.listadossonhos.repository.PlaylistRepository;
import com.ucsal.listadossonhos.viewModel.CriarListaViewModel;
import com.ucsal.listadossonhos.viewModel.FilmeCallback;
import com.ucsal.listadossonhos.viewModel.PlaylistViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CriarListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);
        RecyclerView rvFilme = findViewById(R.id.lista_filme_recycler_view);
        CriarListaViewModel model = new ViewModelProvider(this).get(CriarListaViewModel.class);
        List<Filme> listaFilme = new ArrayList<Filme>();
        final Playlist playlist = new Playlist();
        playlist.setFilmes(new ArrayList<>());
        EditText editText = findViewById(R.id.nome_lista_edit_text);
        Button btn = findViewById(R.id.btn_confirmar);

        Integer idPlaylist = 0;
        if(getIntent().getExtras() != null){
            idPlaylist = getIntent().getExtras().getInt("idPlaylist", 0);
        }

        final ItemFilmeAdapter adapter = new ItemFilmeAdapter(
                listaFilme, filme -> playlist.getFilmes().add(filme),idPlaylist == 0);

        if(idPlaylist != 0){
            Playlist novaPl = PlaylistRepository.obterPlaylist(idPlaylist);
            adapter.mFilme = novaPl.getFilmes();
            btn.setVisibility(View.GONE);
            editText.setText(novaPl.getNome());
            editText.setEnabled(false);


        }else{
            btn.setVisibility(View.VISIBLE);
            editText.setEnabled(true);
            model.loadMovies(new Callback<FilmeRetorno>() {
                @Override
                public void onResponse(Call<FilmeRetorno> call, Response<FilmeRetorno> response) {
                    FilmeRetorno data = response.body();

                    if (data != null) {
                        adapter.mFilme = data.getMovies();
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<FilmeRetorno> call, Throwable t) {

                }
            });
        }

        rvFilme.setAdapter(adapter);

        rvFilme.setLayoutManager(new LinearLayoutManager(this));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = findViewById(R.id.nome_lista_edit_text);
                playlist.setNome(nome.getText().toString());
                PlaylistRepository.adicionarPlaylist(playlist);
                voltar();
            }
        });
    }
    private void voltar(){
        this.finish();
    }
}