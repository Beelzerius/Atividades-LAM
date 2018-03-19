package com.example.alunos.jogoadvinhacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Placar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placar);

 //   }
//    public void carregar(View v){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = arquivo.edit();
        String melhor = arquivo.getString("Best","");
        String historico = arquivo.getString("Hist","");
        TextView best = (TextView) findViewById(R.id.rtl_best);
        TextView hist = (TextView) findViewById(R.id.rtl_hist);
        best.setText(melhor);
        hist.setText(historico);
    }
    public void irJogo(View v){
        Intent i = new Intent(Placar.this, Jogo.class);
        startActivity(i);
    }
}
