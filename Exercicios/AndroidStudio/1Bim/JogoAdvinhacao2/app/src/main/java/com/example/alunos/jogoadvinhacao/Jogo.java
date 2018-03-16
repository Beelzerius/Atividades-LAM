package com.example.alunos.jogoadvinhacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.widget.*;

public class Jogo extends AppCompatActivity {
    public int numero;
    public int tentativas = 0;
    public int limite = 1000;
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

}
