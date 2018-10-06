package com.example.alunos.bd;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class LivroRepository {
    private LivroDAO livroDAO;
    private LiveData<List<Livro>> listaLivros;

    LivroRepository(Application application) {
        LivroRoomDatabase db = LivroRoomDatabase.getDatabase(application);
        livroDAO = db.livroDAO();
        listaLivros = livroDAO.getAllLivros();
    }

    LiveData<List<Livro>> getAllLivros() {
        return listaLivros;
    }

    public void insert (Livro Livro){
        new insertAsyncTask(livroDAO).execute(Livro);
    }

    public void update(Livro livro) {
        new updateAsyncTask(livroDAO).execute(livro);
    }

    private static class insertAsyncTask extends AsyncTask<Livro, Void, Void> {

        private LivroDAO mAsyncTaskDao;

        insertAsyncTask(LivroDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Livro... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
