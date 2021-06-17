package com.ucsal.listadossonhos.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ucsal.listadossonhos.R;
import com.ucsal.listadossonhos.model.Filme;
import com.ucsal.listadossonhos.model.Playlist;

import java.util.List;
import java.util.function.Function;

public class ItemPlaylistAdapter extends RecyclerView.Adapter<ItemPlaylistAdapter.ViewHolder> {
    private Function<Integer,Object> quandoSelecionar;
    private List<Playlist> mPlaylist;

    public ItemPlaylistAdapter(List<Playlist> mPlaylist, Function<Integer,Object> quandoSelecionar) {
        this.mPlaylist = mPlaylist;
        this.quandoSelecionar = quandoSelecionar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View playlistItemView = inflater.inflate(R.layout.playlist_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(playlistItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = mPlaylist.get(position);
        holder.itemView.setOnClickListener(v -> quandoSelecionar.apply(playlist.getId()));
        TextView textView = holder.nomePlaylist;
        textView.setText(playlist.getNome());
    }

    @Override
    public int getItemCount() {
        return mPlaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nomePlaylist;

        public ViewHolder(View itemView) {
            super(itemView);

            nomePlaylist = (TextView) itemView.findViewById(R.id.nome_playlist);

        }
    }
}
