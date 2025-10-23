package com.example.projetofinalmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


    EditText edtEmailL, edtSenhaL;
    Button btnLogar, btnRetornar2;
    Conexao conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        conexao = new Conexao(this);
        edtEmailL = (EditText) findViewById(R.id.edtEmailL);
        edtSenhaL = (EditText) findViewById(R.id.edtSenhaL);
        btnLogar = (Button) findViewById(R.id.btnLogar);
        btnRetornar2 = (Button) findViewById(R.id.btnRetornar2);


        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtEmailL.getText().toString();
                String password = edtSenhaL.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(LoginActivity.this, "E-mail não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Senha não inserida, tente novamente", Toast.LENGTH_SHORT).show();
                } else {

                    String res = conexao.validarLogin(userName, password);
                    if (res.equals("OK")) {


                        SharedPreferences prefs = getSharedPreferences("MeuAppPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putBoolean("isLoggedIn", true);
                        editor.putString("usuarioEmail", userName);
                        editor.apply();


                        Intent i = new Intent(LoginActivity.this, PrincipalActivity.class);
                        startActivity(i);
                        finish();


                    } else {
                        Toast.makeText(LoginActivity.this, "Login ou Senha errado(s)!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });

        btnRetornar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        SharedPreferences prefs = getSharedPreferences("MeuAppPrefs", MODE_PRIVATE);
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {

            Intent i = new Intent(LoginActivity.this, PrincipalActivity.class);
            startActivity(i);
            finish();
        }

    }
}
