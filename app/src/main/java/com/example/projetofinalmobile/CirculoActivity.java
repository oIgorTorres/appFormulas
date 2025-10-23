package com.example.projetofinalmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CirculoActivity extends AppCompatActivity {

    EditText edtRaio;
    Button btnCalcularCirculo, btnRetornar5;
    TextView txtRespCirculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_circulo);

        edtRaio = findViewById(R.id.edtRaio);
        btnCalcularCirculo = findViewById(R.id.btnCalcularCirculo);
        btnRetornar5 = findViewById(R.id.btnRetornar5);
        txtRespCirculo = findViewById(R.id.txtRespCirculo);


        btnCalcularCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edtRaio.getText().toString().isEmpty()) {

                    txtRespCirculo.setText("Por favor, insira o valor do raio.");
                    return;
                }

                double raio = Double.parseDouble(edtRaio.getText().toString());

                double area = Math.PI * Math.pow(raio, 2);

                double diametro = raio * 2;

                double perimetro = 2 * Math.PI * raio;

                txtRespCirculo.setText(String.format(" — Área do circulo: %.3f cm²/m² \n — Diâmetro: %.3f cm²/m² \n — Perímetro: %.3f cm²/m²", area, diametro, perimetro));

            }
        });

        btnRetornar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CirculoActivity.this, Principal2Activity.class);
                startActivity(i);
            }
        });

    }
}