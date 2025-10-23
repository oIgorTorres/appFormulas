package com.example.projetofinalmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {


    EditText edtNomeR, edtEmailR, edtSenhaR;
    Button btnRegistrar, btnRetornar;

    Conexao conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        conexao = new Conexao(this);

        edtNomeR = (EditText) findViewById(R.id.edtNomeR);
        edtEmailR = (EditText) findViewById(R.id.edtEmailR);
        edtSenhaR = (EditText) findViewById(R.id.edtSenhaR);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRetornar = (Button) findViewById(R.id.btnRetornar);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtEmailR.getText().toString();
                String nome = edtNomeR.getText().toString();
                String senha = edtSenhaR.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(RegistrarActivity.this, "Insira o E-MAIL DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (nome.equals("")) {
                    Toast.makeText(RegistrarActivity.this, "Insira o NOME DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (senha.equals("")) {
                    Toast.makeText(RegistrarActivity.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else {
                    long res = conexao.criarUtilizador(userName, senha);
                    if (res > 0) {
                        Toast.makeText(RegistrarActivity.this, "Resgistro OK", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegistrarActivity.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });


        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistrarActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

}

