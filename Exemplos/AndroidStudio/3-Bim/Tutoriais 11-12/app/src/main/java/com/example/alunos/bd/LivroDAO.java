package com.example.alunos.bd;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface LivroDAO {
    @Insert
    void  insert(Livro livro);

    @Query("SELECT * FROM Livro ORDER BY titulo ASC")
    LiveData<List<Livro>> getAllLivros();

    @Update
    int update(Livro livro);
}
