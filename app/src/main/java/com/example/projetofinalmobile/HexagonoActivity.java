package com.example.projetofinalmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HexagonoActivity extends AppCompatActivity {

    EditText edtLados;
    Button btnCalcularHexagono, btnRetornar7;
    TextView txtRespHexagono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hexagono);

        edtLados = findViewById(R.id.edtLados);
        btnCalcularHexagono =  findViewById(R.id.btnCalcularHexagono);
        txtRespHexagono = findViewById(R.id.txtRespHexagono);
        btnRetornar7 = findViewById(R.id.btnRetornar7);


        btnCalcularHexagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edtLados.getText().toString().isEmpty()) {
                    txtRespHexagono.setText("Por favor, insira o valor do lado.");
                    return;
                }


                double lado = Double.parseDouble(edtLados.getText().toString());


                double area = (6 * Math.pow(lado, 2) * Math.sqrt(3)) / 4;


                txtRespHexagono.setText(String.format("Área do hexágono: %.3f %s", area, "cm²/m²"));


            }
        });


        btnRetornar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HexagonoActivity.this, PrincipalActivity.class);
                startActivity(i);
            }
        });



    }
}
