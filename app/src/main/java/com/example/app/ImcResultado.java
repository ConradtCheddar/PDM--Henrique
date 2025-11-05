package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ImcResultado extends AppCompatActivity {

    private TextView resultadoText, descricaoText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_resultado);

        resultadoText = findViewById(R.id.Resultado);
        descricaoText = findViewById(R.id.descricao);
        imageView = findViewById(R.id.imageView3);

        double imc = getIntent().getDoubleExtra("IMC_RESULT", 0);

        resultadoText.setText(String.format("%.2f", imc));

        String descricao = "";

        if (imc<18.9){
            imageView.setImageResource(R.drawable.abaixopeso);
            descricao = "abaixo do peso";
        }
        if (imc>=18.9 && imc < 25 ){
            imageView.setImageResource(R.drawable.normal);
            descricao = "peso normal";}
        if (imc>=25 && imc < 30 ){
            imageView.setImageResource(R.drawable.sobrepeso);
            descricao = "acima do peso";
        }
        if (imc>=25 && imc < 35 ){
            imageView.setImageResource(R.drawable.obesidade1);
            descricao = "obeso";
        }

        descricaoText.setText(descricao);
    }
}
