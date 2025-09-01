package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editTextMin, editTextMax;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button =findViewById(R.id.button);
        editTextMin=findViewById(R.id.edmin);
        editTextMax=findViewById(R.id.edmax);
        tv=findViewById(R.id.tvResultado);

        button.setOnClickListener(v -> {
            Random random = new Random();
            int min, max;
            min = Integer.parseInt(editTextMin.getText().toString());
            max = Integer.parseInt(editTextMax.getText().toString());
            int delta= max-min;
            int sorteado = random.nextInt(delta)+min+1;
            tv.setText(Integer.toString(sorteado));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}