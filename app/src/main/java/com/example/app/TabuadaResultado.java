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
        for (int i = 1; i < 11; i++) {

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}