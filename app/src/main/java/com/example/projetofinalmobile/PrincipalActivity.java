package com.example.projetofinalmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {

    Button btnQuadrado, btnTriangulo, btnHexagono, btnPagina2;
    TextView txtLogoff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

        btnQuadrado = findViewById(R.id.btnQuadrado);
        btnTriangulo = findViewById(R.id.btnTriangulo);
        btnHexagono = findViewById(R.id.btnHexagono);
        btnPagina2 = findViewById(R.id.btnPagina2);
        txtLogoff =  findViewById(R.id.txtLogoff);


        btnQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, QuadradoActivity.class);
                startActivity(i);
            }
        });

        btnTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, TrianguloActivity.class);
                startActivity(i);
            }
        });

        btnHexagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, HexagonoActivity.class);
                startActivity(i);
            }
        });


        btnPagina2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, Principal2Activity.class);
                startActivity(i);
            }
        });

        txtLogoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("MeuAppPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();


                Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


    }

}