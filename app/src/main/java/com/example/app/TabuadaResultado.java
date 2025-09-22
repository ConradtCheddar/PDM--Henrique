package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TabuadaResultado extends AppCompatActivity {

    // o codigo mais porco de toda a minha vida, me sinto invergonhado

    @SuppressLint("MissingInflatedId")
    TextView Vezes1, Vezes2, Vezes3, Vezes4, Vezes5, Vezes6, Vezes7, Vezes8, Vezes9, Vezes10;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tabuada_resultado);
        Vezes1 = findViewById(R.id.Vezes1);
        Vezes2 = findViewById(R.id.Vezes2);
        Vezes3 = findViewById(R.id.Vezes3);
        Vezes4 = findViewById(R.id.Vezes4);
        Vezes5 = findViewById(R.id.Vezes5);
        Vezes6 = findViewById(R.id.Vezes6);
        Vezes7 = findViewById(R.id.Vezes7);
        Vezes8 = findViewById(R.id.Vezes8);
        Vezes9 = findViewById(R.id.Vezes9);
        Vezes10 = findViewById(R.id.Vezes10);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        double numero = bundle.getDouble("Numero");
        double V1 = numero * 1;
        double V2 = numero * 2;
        double V3 = numero * 3;
        double V4 = numero * 4;
        double V5 = numero * 5;
        double V6 = numero * 6;
        double V7 = numero * 7;
        double V8 = numero * 8;
        double V9 = numero * 9;
        double V10 = numero * 10;
        Vezes1.setText(Integer.toString((int) V1));
        Vezes2.setText(Integer.toString((int) V2));
        Vezes3.setText(Integer.toString((int) V3));
        Vezes4.setText(Integer.toString((int) V4));
        Vezes5.setText(Integer.toString((int) V5));
        Vezes6.setText(Integer.toString((int) V6));
        Vezes7.setText(Integer.toString((int) V7));
        Vezes8.setText(Integer.toString((int) V8));
        Vezes9.setText(Integer.toString((int) V9));
        Vezes10.setText(Integer.toString((int) V10));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}