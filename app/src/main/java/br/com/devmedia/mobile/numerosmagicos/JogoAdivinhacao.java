package br.com.devmedia.mobile.numerosmagicos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JogoAdivinhacao extends AppCompatActivity {

    Button btnChute = null;
    Button btnNovoJogo = null;
    EditText inputChute = null;
    TextView textMensagem = null;

    boolean jogoFinalizado = false;
    int numeroSecreto = 0;
    int chutes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_adivinhacao);

        btnChute = (Button) findViewById(R.id.btnChute);
        btnChute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processaChute();
            }
        });

        btnNovoJogo = (Button) findViewById(R.id.btnNovoJogo);
        btnNovoJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoJogo();
            }
        });

        inputChute = (EditText) findViewById(R.id.inputChute);
        textMensagem = (TextView) findViewById(R.id.textMensagem);

        novoJogo();

    }

    private void processaChute(){

        String chute = inputChute.getText().toString();
        inputChute.setText("");

        if(chute.length() == 0)
            return;

        int valor = Integer.valueOf(chute);

        if(valor > numeroSecreto){
            textMensagem.setText(R.string.mensagem_valor_menor);
            chutes++;
        }else if(valor < numeroSecreto){
            textMensagem.setText(R.string.mensagem_valor_maior);
            chutes++;
        }else{
            chutes++;
            textMensagem.setText(String.format("Acertou! \n O número secreto era %d! \n Você precisou de %d chutes para acertar!", numeroSecreto, chutes));
            jogoFinalizado = true;
            btnChute.setEnabled(false);
        }

    }

    private void novoJogo(){

        numeroSecreto = (int) (Math.random()*100);
        textMensagem.setText(R.string.text_mensagem);
        inputChute.setText("");
        btnChute.setEnabled(true);
        jogoFinalizado = false;
        chutes = 0;
    }
}
