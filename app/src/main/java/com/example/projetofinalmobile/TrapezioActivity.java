package com.example.projetofinalmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TrapezioActivity extends AppCompatActivity {

    EditText edtBaseMaior, edtBaseMenor, edtAlturaTrapezio;
    Button btnCalcularTrapezio, btnRetornar8;
    TextView txtRespTrapezio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trapezio);

        edtBaseMaior = findViewById(R.id.edtBaseMaior);
        edtBaseMenor = findViewById(R.id.edtBaseMenor);
        edtAlturaTrapezio = findViewById(R.id.edtAlturaTrapezio);
        btnCalcularTrapezio = findViewById(R.id.btnCalcularTrapezio);
        btnRetornar8 = findViewById(R.id.btnRetornar8);
        txtRespTrapezio = findViewById(R.id.txtRespTrapezio);

        btnCalcularTrapezio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edtBaseMaior.getText().toString().isEmpty() || edtBaseMenor.getText().toString().isEmpty() || edtAlturaTrapezio.getText().toString().isEmpty()) {

                    txtRespTrapezio.setText("Por favor, insira o valor da base maior, base menor e altura.");
                    return;
                }

                double baseMaior = Double.parseDouble(edtBaseMaior.getText().toString());

                double baseMenor = Double.parseDouble(edtBaseMenor.getText().toString());

                double altura = Double.parseDouble(edtAlturaTrapezio.getText().toString());

                double area = ((baseMaior + baseMenor) * altura) / 2;

                txtRespTrapezio.setText(String.format("Área do trapézio: %.3f %s", area, "cm²/m²"));




            }



        });

        btnRetornar8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrapezioActivity.this, Principal2Activity.class);
                startActivity(i);
            }
        });


    }
}