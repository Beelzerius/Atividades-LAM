package com.example.alunos.jogoadvinhacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class Jogo extends AppCompatActivity {
    public int numero;
    public int tentativas = 0;
    public int maxTentativas = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        numero = gerarNumero(10);
    }
    public int gerarNumero(int limite){
        Random gerador = new Random();
        int numGerado = (gerador.nextInt()%limite)+1;
        return numGerado;
    }
    public void chutarNumero(View v) {
        TextView etiqueta = (TextView) findViewById(R.id.rtl_mensagem);
        EditText userInput = findViewById(R.id.pt_numero);
        Button button = (Button)findViewById(R.id.btn_chute);
        int chute = Integer.parseInt(userInput.getText().toString());
        if(tentativas != maxTentativas){
            if(numero == chute){
                tentativas = 3;
                button.setText(R.string.lblRestart);
                userInput.setText("");
                etiqueta.setText(R.string.lblWin);
            }else{
                tentativas++;
                if(tentativas == maxTentativas){
                    tentativas = 3;
                    button.setText(R.string.lblRestart);
                    userInput.setText("");
                    etiqueta.setText(R.string.lblLose);
                }
            }
        }else{
            tentativas = 0;
            button.setText(R.string.lblButton);
            userInput.setText("");
            etiqueta.setText(R.string.lblText);
            numero = gerarNumero(10);
        }


    }

}
