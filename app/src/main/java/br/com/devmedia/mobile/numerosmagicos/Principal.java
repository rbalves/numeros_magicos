package br.com.devmedia.mobile.numerosmagicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnAdivinhar = (Button) findViewById(R.id.btnAdivinhar);

        btnAdivinhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this, JogoAdivinhacao.class);
                startActivity(intent);
            }
        });
    }
}
