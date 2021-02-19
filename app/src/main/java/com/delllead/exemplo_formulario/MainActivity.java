package com.delllead.exemplo_formulario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/*Projeto desenvolvido por Jessica Rangel Freire
* Local: Rio de Janeiro - RJ/Brasil
* Período: 12/08/2020 a 25/08/2020*/
public class MainActivity extends Activity {

    private EditText cmp_nome, cmp_idade;
    private RadioGroup radioGp;
    private Button btnEnviar, btnLimpar;
    private String genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmp_nome = findViewById(R.id.editText1);
        cmp_idade = findViewById(R.id.editText2);

        radioGp = findViewById(R.id.radioGp);

        btnEnviar = findViewById(R.id.button1);
        btnLimpar = findViewById(R.id.button2);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idEscolha = radioGp.getCheckedRadioButtonId();
                if((cmp_nome.length()!=0)&&(cmp_idade.length()!=0)){
                    if (idEscolha == -1) { //Nenhuma opção escolhida
                        Toast.makeText(getBaseContext(), "Você não escolheu o gênero.", Toast.LENGTH_LONG).show();
                    } else { //O usuário preencheu os input texts e escolheu o gênero
                        findRadioButton(idEscolha); //Identifica a opção escolhida
                        proximaTela(view); //Envia a informação de cada usuário e segue para a próxima página
                    }
                } else{ //Algum(ns) dado(s) faltando...
                    Toast.makeText(getBaseContext(), "Formulário incompleto.", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cmp_idade.setText(" ");
                cmp_nome.setText(" ");
                radioGp.clearCheck();
            }
        });

        radioGp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idEscolha) {
                findRadioButton(idEscolha);
            }
        });
    }

    private void findRadioButton(int idEscolha) {
        switch (idEscolha){
            case R.id.radioButton1:
                genero = "feminino";
                break;
            case R.id.radioButton2:
                genero = "masculino";
                break;
        }
    }

    public void proximaTela(View view){
        String nome = cmp_nome.getText().toString();

        String age = cmp_idade.getText().toString();
        int idade = Integer.parseInt(age);

        Intent minhaIntent = new Intent(this, AnswerActivity.class);

        minhaIntent.putExtra("nomeUsu", nome);
        minhaIntent.putExtra("idadeUsu", idade);
        minhaIntent.putExtra("generoUsu", genero);

        startActivity(minhaIntent);
        finish();
    }
}