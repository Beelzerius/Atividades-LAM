package com.example.alunos.bd;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity
public class Livro implements Parcelable{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String titulo;
    private String autor;
    private String editora;

    public Livro(@NonNull int id, @NonNull String titulo, @NonNull String autor, @NonNull String editora){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    protected Livro(Parcel in) {
        id = in.readInt();
        titulo = in.readString();
        autor = in.readString();
        editora = in.readString();
    }

    public static final Creator<Livro> CREATOR = new Creator<Livro>() {
        @Override
        public Livro createFromParcel(Parcel in) {
            return new Livro(in);
        }

        @Override
        public Livro[] newArray(int size) {
            return new Livro[size];
        }
    };

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(titulo);
        parcel.writeString(autor);
        parcel.writeString(editora);
    }
}
