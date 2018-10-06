package com.example.alunos.bd;

import android.os.AsyncTask;

class updateAsyncTask extends AsyncTask<Livro, Void,Void>{
    private LivroDAO mAsyncTaskDao;

    private updateAsyncTask(LivroDAO dao){
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(Livro... params){
        int update = mAsyncTaskDao.update(params[0]);
        return null;
    }
}
