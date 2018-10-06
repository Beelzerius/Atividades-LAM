package com.example.alunos.bd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

    public class ADDActivity extends AppCompatActivity {
        private EditText editTitulo;
        private EditText editAutor;
        private EditText editEditora;
        public static final String TITLE_REPLY = "com.example.adnroid.livrosql.TITLE_REPLY";
        public static final String AUTOR_REPLY = "com.example.adnroid.livrosql.AUTOR_REPLY";
        public static final String EDITORA_REPLY = "com.example.adnroid.livrosql.EDITORA_REPLY";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_activity);

            editTitulo = findViewById(R.id.txtTitulo);
            editAutor = findViewById(R.id.txtAutor);
            editEditora = findViewById(R.id.txtEditora);
        }

        public void salvaLivro(View v){
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(editTitulo.getText())||
                    TextUtils.isEmpty(editAutor.getText()) ||
                    TextUtils.isEmpty((editEditora.getText()))) {
                setResult(RESULT_CANCELED,replyIntent);
            } else {
                String titulo = editTitulo.getText().toString();
                String autor = editAutor.getText().toString();
                String editora = editEditora.getText().toString();
                replyIntent.putExtra(TITLE_REPLY, titulo);
                replyIntent.putExtra(AUTOR_REPLY, autor);
                replyIntent.putExtra(EDITORA_REPLY, editora);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        }

    }

