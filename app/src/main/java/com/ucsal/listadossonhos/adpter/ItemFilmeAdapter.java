package com.ucsal.listadossonhos.adpter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.ucsal.listadossonhos.R;
import com.ucsal.listadossonhos.model.Filme;

import java.util.List;
import java.util.function.Function;

public class ItemFilmeAdapter extends RecyclerView.Adapter<ItemFilmeAdapter.ViewHolder> {
    public List<Filme> mFilme;
    public Function<Filme,Object>  quandoAdicionar;
    private Context context;

    public ItemFilmeAdapter(List<Filme> mFilme, Function<Filme,Object> quandoAdicionar) {
        this.mFilme = mFilme;
        this.quandoAdicionar = quandoAdicionar;
    }

    @NonNull
    @Override
    public ItemFilmeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View filmeItemView = inflater.inflate(R.layout.filme_item, parent, false);

        // Return a new holder instance
        ItemFilmeAdapter.ViewHolder viewHolder = new ItemFilmeAdapter.ViewHolder(filmeItemView);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ItemFilmeAdapter.ViewHolder holder, int position) {
        Filme filme = mFilme.get(position);

        // Set item views based on your views and data model
        TextView textViewNome = holder.nomeFilme;
        textViewNome.setText(filme.getTitle());
        ImageView imgView = holder.imgView;
        filme.loadImage(context,imgView);
        TextView textViewNota = holder.notaFilme;
        textViewNota.setText(filme.getVote_average().toString());
        holder.btnAdd.setOnClickListener(v -> quandoAdicionar.apply(filme));
    }

    @Override
    public int getItemCount() {
        return mFilme.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nomeFilme;
        public ImageView imgView;
        public TextView notaFilme;
        public ImageButton btnAdd;

        public ViewHolder(View itemView) {
            super(itemView);

            nomeFilme = (TextView) itemView.findViewById(R.id.nome_filme);
            imgView= (ImageView) itemView.findViewById(R.id.filme_img);
            notaFilme = (TextView) itemView.findViewById(R.id.nota);
            btnAdd = (ImageButton) itemView.findViewById(R.id.btn_add);

        }
    }
}
