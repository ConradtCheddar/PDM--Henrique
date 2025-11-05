package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso, editAltura;
    private Button buttonCalcular;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.editpeso);
        editAltura = findViewById(R.id.editaltura);
        buttonCalcular = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesoStr = editPeso.getText().toString();
                String alturaStr = editAltura.getText().toString();

                imageView.setImageResource(R.drawable.perfil);

                if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double peso = Double.parseDouble(pesoStr);
                    double altura = Double.parseDouble(alturaStr);

                    if (altura <= 0) {
                        Toast.makeText(MainActivity.this, "Altura inválida!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double imc = peso / (altura * altura);

                    Intent intent = new Intent(MainActivity.this, ImcResultado.class);
                    intent.putExtra("IMC_RESULT", imc);
                    startActivity(intent);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Digite apenas números válidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
