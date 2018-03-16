package com.example.alunos.jogoadvinhacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Placar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placar);
        carregar();
    }
    public void carregar(){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String melhor = arquivo.getString("Best","");
        String historico = arquivo.getString("Hist","");

    }
}
