package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> nomes = new ArrayList<>(Arrays.asList("eu", "voce"));
    ListView listView;
    Button button;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, nomes);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            Toast.makeText(getApplicationContext(), nomes.get(position), Toast.LENGTH_LONG).show();
//        });

        button.setOnClickListener(v -> {
            String i = String.valueOf(editText.getText());
            nomes.add(i);
            adapter.notifyDataSetChanged();
            editText.setText("");
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            new android.app.AlertDialog.Builder(MainActivity.this)
                    .setTitle("Excluir item")
                    .setMessage("Deseja realmente excluir \"" + nomes.get(position) + "\"?")
                    .setPositiveButton("Sim", (dialog, which) -> {
                        nomes.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Item excluído", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Não", null)
                    .show();
        });

    }
}