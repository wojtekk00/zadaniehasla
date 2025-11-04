package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonZatwierdz;
    private EditText editTextEmail;
    private EditText editTextHaslo;
    private EditText editTextPowtorzHaslo;
    private TextView textViewKomunikat;

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

        buttonZatwierdz = findViewById(R.id.buttonZatwierdz);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextHaslo = findViewById(R.id.editTextHaslo);
        editTextPowtorzHaslo = findViewById(R.id.editTextPowtorzHaslo);
        textViewKomunikat = findViewById(R.id.textViewKomunikat);

        buttonZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String haslo = editTextHaslo.getText().toString();
                String powtorzHaslo = editTextPowtorzHaslo.getText().toString();

                if (!email.contains("@")){
                    textViewKomunikat.setText("Nieprawidłowy adres email");
                }
                if (!haslo.equals(powtorzHaslo)){
                    textViewKomunikat.setText("Hasła się różnią");
                }
                else if (email.contains("@") && haslo.equals(powtorzHaslo)){
                    textViewKomunikat.setText("Witaj " + email);
                }
            }
        });
    }
}