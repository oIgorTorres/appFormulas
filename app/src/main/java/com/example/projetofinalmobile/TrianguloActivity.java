package com.example.projetofinalmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TrianguloActivity extends AppCompatActivity {

    EditText edtBase, edtAltura;
    Button btnCalcularTriangulo, btnRetornar4;
    TextView txtRespTriangulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_triangulo);

        edtBase = findViewById(R.id.edtBase);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcularTriangulo = findViewById(R.id.btnCalcularTriangulo);
        btnRetornar4 = findViewById(R.id.btnRetornar4);
        txtRespTriangulo = findViewById(R.id.txtRespTriangulo);


        btnCalcularTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edtBase.getText().toString().isEmpty() || edtAltura.getText().toString().isEmpty()) {

                    txtRespTriangulo.setText("Por favor, insira o valor da base e altura.");
                    return;
                }


                double base = Double.parseDouble(edtBase.getText().toString());

                double altura = Double.parseDouble(edtAltura.getText().toString());

                double area = (base * altura) / 2;

                txtRespTriangulo.setText(String.format("Área do triangulo: %.3f %s", area, "cm²/m²"));

            }

        });

        btnRetornar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrianguloActivity.this, PrincipalActivity.class);
                startActivity(i);
            }
        });
    }
}
