package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImcResultado extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    TextView resultado;
    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_resultado);
        Bundle bundle=getIntent().getExtras();
        Double peso= bundle.getDouble("peso");
        Double altura= bundle.getDouble("altura");
        Double imc=(peso/(altura*altura));

        TextView tvIMC =findViewById(R.id.Resultado);
        TextView tvDescricao =findViewById(R.id.descrição);
        ImageView imageView=findViewById(R.id.imageView3);


        // Definindo o valor do IMC no TextView
        tvIMC.setText(String.format("%.2f", imc)+" kg/m²");
/*
IMC abaixo de 18,5: Abaixo do peso
IMC entre 18,5 e 24,9: Peso normal
IMC entre 25 e 29,9: Sobrepeso
IMC entre 30 e 34,9: Obesidade grau 1
IMC entre 35 e 39,9: Obesidade grau 2
IMC acima de 40: Obesidade grau 3
 */
        if (imc<18.5){
            tvDescricao.setText("Abaixo do peso");
            imageView.setImageResource(R.drawable.abaixopeso);
        }else if (imc>=18.5 && imc<=24.9){
            tvDescricao.setText("Peso normal");
            imageView.setImageResource(R.drawable.normal);
        }else if (imc>=25 && imc<=29.9){
            tvDescricao.setText("Sobrepeso");
            imageView.setImageResource(R.drawable.sobrepeso);
        }else if (imc>=30 && imc<=34.9){
            tvDescricao.setText("Obesidade grau 1");
            imageView.setImageResource(R.drawable.obesidade1);
        }else if (imc>=35 && imc<=39.9){
            tvDescricao.setText("Obesidade grau 2");
            imageView.setImageResource(R.drawable.obesidade2);
        }else {
            tvDescricao.setText("Obesidade grau 3");
            imageView.setImageResource(R.drawable.obesidade3);
        }


    }
}