package com.example.alunos.bd;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Livro.class}, version = 1)
public abstract class LivroRoomDatabase extends RoomDatabase{
    public abstract LivroDAO livroDAO();

    private static LivroRoomDatabase INSTANCE;


    public static LivroRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null){
            synchronized (LivroRoomDatabase.class) {
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LivroRoomDatabase.class, "livro_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
