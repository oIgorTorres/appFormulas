package com.example.projetofinalmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Principal2Activity extends AppCompatActivity {

    Button btnCirculo, btnTrapezio, btnVoltar, btnCilindro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal2);

        btnCirculo = findViewById(R.id.btnCirculo);
        btnTrapezio = findViewById(R.id.btnTrapezio);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnCilindro = findViewById(R.id.btnCilindro);



        btnTrapezio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Principal2Activity.this, TrapezioActivity.class);
                startActivity(i);
            }
        });

        btnCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Principal2Activity.this, CirculoActivity.class);
                startActivity(i);
            }
        });

        btnCilindro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Principal2Activity.this, CilindroActivity.class);
                startActivity(i);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Principal2Activity.this, PrincipalActivity.class);
                startActivity(i);
            }
        });
    }

}
