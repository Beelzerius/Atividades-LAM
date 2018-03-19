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
        return (gerador.nextInt()%limite)+1;
    }
    public void chutarNumero(View v) {
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = arquivo.edit();
        int chute = 0;
        TextView etiqueta = (TextView) findViewById(R.id.rtl_mensagem);
        EditText userInput = findViewById(R.id.pt_numero);
        Button button = (Button)findViewById(R.id.btn_chute);
        if(chute != numero){
            tentativas++;
            chute = Integer.parseInt(userInput.getText().toString());
            if(numero == chute){
                button.setText(R.string.lblRestart);
                userInput.setText("");
                etiqueta.setText(R.string.lblWin);
                String rec = arquivo.getString("Best","0");
                int melhor = Integer.parseInt(rec);
                if (rec == "0" || melhor>tentativas) {
                    editor.putString("Best",Integer.toString(tentativas));
                }
                rec = arquivo.getString("Hist","");
                rec = Integer.toString(tentativas)+"/n"+rec;
                editor.putString("Best",rec);

            }else{
                if(numero>chute){
                    userInput.setText("");
                    etiqueta.setText(R.string.lblM);
                }else {
                    userInput.setText("");
                    etiqueta.setText(R.string.lblL);
                }
            }
        }else{
            button.setText(R.string.lblButton);
            userInput.setText("");
            etiqueta.setText(R.string.lblText);
            numero = gerarNumero();
            tentativas = 0;
        }


    }
    public void irPlacar(View v){
        Intent i = new Intent(Jogo.this, Placar.class);
        startActivity(i);
    }

}
