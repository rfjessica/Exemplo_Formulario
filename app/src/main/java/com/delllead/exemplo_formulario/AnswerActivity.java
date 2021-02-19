package com.delllead.exemplo_formulario;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnswerActivity extends Activity {

    private String nome_usu, genero_usu;
    private int idade_usu = 0;
    private Button btnVoltar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Intent minhaIntent = getIntent(); //Obtém dados da intent principal

        nome_usu = minhaIntent.getStringExtra("nomeUsu");
        idade_usu = minhaIntent.getIntExtra("idadeUsu", 0);
        genero_usu = minhaIntent.getStringExtra("generoUsu");

        TextView msg_nome = findViewById(R.id.textView4);
        msg_nome.setText(nome_usu);

        TextView msg_idade = findViewById(R.id.textView5);
        String msg_age = (String) getText(R.string.textVw2);
        String vIdade = String.valueOf(idade_usu);

        msg_idade.setText(msg_age + " " + vIdade);

        TextView msg_genero = findViewById(R.id.textView6);
        String msg_gender = (String) getText(R.string.msGender);
        msg_genero.setText(msg_gender + " " + genero_usu);

        btnVoltar = findViewById(R.id.button3);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaInicio(view);
            }
        });
    }

    public void retornaInicio(View view){
        Intent minhaIntent2 = new Intent(this, MainActivity.class);
        startActivity(minhaIntent2);
        finish();
    }
}