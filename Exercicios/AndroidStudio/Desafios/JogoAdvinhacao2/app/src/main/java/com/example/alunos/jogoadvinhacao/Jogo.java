package com.example.alunos.jogoadvinhacao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.widget.*;
import android.util.*;
import android.*;

public class Jogo extends AppCompatActivity {
    public int numero;
    public int tentativas = 0;
    public int limite = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        numero = gerarNumero();
    }
    public int gerarNumero(){
        Random gerador = new Random();
        return (gerador.nextInt(limite))+1;
    }
    public void chutarNumero(View v) {
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = arquivo.edit();
        int chute = 0;
        TextView etiqueta = (TextView) findViewById(R.id.rtl_mensagem);
        EditText userInput = findViewById(R.id.pt_numero);
        Button button = (Button)findViewById(R.id.btn_chute);
            try {
                if(userInput.getText().toString() != "") {
                    chute = Integer.parseInt(userInput.getText().toString());
                }else{
                    chute = -1;
                }
            } catch (Exception e) {
                chute = 0;
            }
        if(chute!= numero){
            tentativas++;
            if(chute != -1){
                if (numero > chute) {
                    userInput.setText("");
                    etiqueta.setText(R.string.lblM);
                } else {
                    userInput.setText("");
                    etiqueta.setText(R.string.lblL);
                }
                if (chute == 0) {
                    button.setText(R.string.lblButton);
                    userInput.setText("");
                    etiqueta.setText(R.string.lblText);
                    numero = gerarNumero();
                    tentativas = 0;
                }
            }
        }else{
            button.setText(R.string.lblRestart);
            userInput.setText("");
            etiqueta.setText(R.string.lblWin);
            int melhor = arquivo.getInt("Best", 0);
            if (melhor == 0 || melhor > tentativas) {
                editor.putInt("Best",tentativas);
            }
            String rec = arquivo.getString("Hist", "");
            rec = Integer.toString(tentativas) + "/n" + rec;
            editor.putString("Hist", rec);
            editor.commit();
        }
    }
    public void irPlacar(View v){
        Intent i = new Intent(Jogo.this, Placar.class);
        startActivity(i);
    }

}
