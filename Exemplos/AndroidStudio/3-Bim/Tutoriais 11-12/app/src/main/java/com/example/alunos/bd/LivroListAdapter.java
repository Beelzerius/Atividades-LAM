package com.example.alunos.bd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class LivroListAdapter extends RecyclerView.Adapter<LivroListAdapter.LivroViewHolder> {

    class LivroViewHolder extends RecyclerView.ViewHolder {

        private final TextView tituloItemView;
        private final TextView autorItemView;
        private final TextView editoraItemView;
        private final ImageButton editaLivro;
        private final ImageButton deletaLivro;

        private LivroViewHolder(View itemView) {
            super(itemView);
            tituloItemView = itemView.findViewById(R.id.titulo);
            autorItemView = itemView.findViewById(R.id.autor);
            editoraItemView = itemView.findViewById(R.id.editora);
            editaLivro = itemView.findViewById(R.id.editButton);
            deletaLivro = itemView.findViewById(R.id.deleteButton);
        }
    }

    private final LayoutInflater mInflater;
    private List<Livro> listaLivro;

    LivroListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LivroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);

        return new LivroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final LivroViewHolder holder, int position) {
        if (listaLivro != null){
            Livro current = listaLivro.get(position);
            holder.tituloItemView.setText(current.getTitulo());
            holder.autorItemView.setText(current.getAutor());
            holder.editoraItemView.setText(current.getEditora());
        }else {
            holder.tituloItemView.setText("Sem dados");
            holder.autorItemView.setText("Sem dados");
            holder.editoraItemView.setText("Sem dados");
        }
        holder.editaLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaLivro != null){
                    Livro current = listaLivro.get(holder.getAdapterPosition());
                    Intent intent = new Intent(context, EditActivity.class);
                    intent.putExtra("livro",current);
                    ((Activity)context).startActivityForResult(intent,MainActivity.EDIT_LIVRO_ACTIVITY_REQUEST_CODE);
                }
            }
        });
    }

    void setWords(List<Livro> livros){
        listaLivro = livros;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (listaLivro != null){
            return listaLivro.size();
        }else {
            return 0;
        }
    }


    }

