package com.example.projetofinalmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.color.utilities.MathUtils;

public class CilindroActivity extends AppCompatActivity {

    EditText edtRaioCilindro, edtAlturaCilindro;
    Button btnCalcularCilindro, btnRetornar6;
    TextView txtRespCilindro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cilindro);

        edtRaioCilindro = findViewById(R.id.edtRaioCilindro);
        edtAlturaCilindro = findViewById(R.id.edtAlturaCilindro);
        btnCalcularCilindro = findViewById(R.id.btnCalcularCilindro);
        btnRetornar6 = findViewById(R.id.btnRetornar6);
        txtRespCilindro = findViewById(R.id.txtRespCilindro);

        btnCalcularCilindro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edtRaioCilindro.getText().toString().isEmpty() || edtAlturaCilindro.getText().toString().isEmpty()) {

                    txtRespCilindro.setText("Por favor, insira o valor do raio e da altura.");
                    return;
                }

                double raio = Double.parseDouble(edtRaioCilindro.getText().toString());

                double altura = Double.parseDouble(edtAlturaCilindro.getText().toString());

                double areaTotal = 2 * Math.PI * Math.pow(raio, 2) + 2 * Math.PI * raio * altura;

                double areaBase = Math.PI * Math.pow(raio, 2);

                Double areaLateral = 2 * Math.PI * raio * altura;

                txtRespCilindro.setText(String.format(" — Área Total: %.3f cm²/m² \n — Área Base: %.3f cm²/m² \n — Área Lateral: %.3f cm²/m²", areaTotal, areaBase, areaLateral));


            }





        });

        btnRetornar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CilindroActivity.this, Principal2Activity.class);
                startActivity(i);
            }
        });

    }
}

