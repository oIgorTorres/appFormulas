package com.example.projetofinalmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class QuadradoActivity extends AppCompatActivity {

    EditText edtLado1, edtLado2;
    Button btnCalcularQuadrado, btnRetornar3;
    TextView txtRespQuadrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quadrado);

        edtLado1 = findViewById(R.id.edtLado1);
        edtLado2 = findViewById(R.id.edtLado2);
        btnCalcularQuadrado = findViewById(R.id.btnCalcularQuadrado);
        btnRetornar3 = findViewById(R.id.btnRetornar3);
        txtRespQuadrado = findViewById(R.id.txtRespQuadrado);


        btnCalcularQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edtLado1.getText().toString().isEmpty() || edtLado2.getText().toString().isEmpty()) {

                    txtRespQuadrado.setText("Por favor, insira o valor do lado1 e do lado2.");
                    return;
                }

                double lado1 = Double.parseDouble(edtLado1.getText().toString());

                double lado2 = Double.parseDouble(edtLado2.getText().toString());

                double area = lado1 * lado2;

                txtRespQuadrado.setText(String.format("Área do quadrado/retângulo: " +area+ " cm²/m²"));


    }

});

        btnRetornar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuadradoActivity.this, PrincipalActivity.class);
                startActivity(i);
            }
        });

    }
}

