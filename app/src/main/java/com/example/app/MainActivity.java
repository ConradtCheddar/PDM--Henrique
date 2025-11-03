package com.example.app;

import android.content.ContentValues;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = openOrCreateDatabase("app_database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE if not exists notas (id integer primary key autoincrement," +
                " titulo varchar, texto text)");
        ContentValues values = new ContentValues();
        values.put("titulo","natal");
        values.put("texto","hohoho");
        db.insert("notas", null, values);


        button.setOnClickListener(v->{
            EditText editText = findViewById(R.id.editTextText);
            String texto = editText.getText().toString();
            ContentValues contentValues = new ContentValues();
            contentValues.put("Titulo","sigma");
            contentValues.put("texto",texto);
            db.insert("notas", null, contentValues);
            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
        });



    }
}