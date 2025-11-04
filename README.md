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

import java.lang.reflect.Array;
import java.util.ArrayList;

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

        char[] maleLitery = "abcdefghijklmnoprstuwxyz".toCharArray();
        char[] duzeLitery = "ABCDEFGHIJKLMNOPRSTUWXYZ".toCharArray();
        char[] liczby = "1234567890".toCharArray();
        char[] znakiSpecjalne = "!@#$%^&*()_+-=".toCharArray();

        buttonZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String haslo = editTextHaslo.getText().toString();
                String powtorzHaslo = editTextPowtorzHaslo.getText().toString();
                char[] hasloCharArr = haslo.toCharArray();

                int bledy = 0;
                boolean czyZawieraMale = false;
                boolean czyZawieraDuze = false;
                boolean czyZawieraZnaki = false;
                boolean czyZawieraCyfry = false;

                if (!email.contains("@")){
                    textViewKomunikat.setText("Nieprawidłowy adres email");
                    bledy++;
                }
                if (haslo.length() < 12){
                    textViewKomunikat.setText("Zbyt krótkie hasło");
                    bledy++;
                }
                for (int i=0; i<hasloCharArr.length; i++){
                    for (int j=0; j<maleLitery.length; j++){
                        if (hasloCharArr[i] == maleLitery[j]){
                            czyZawieraMale = true;
                            break;
                        }
                    }
                    if (czyZawieraMale == true){
                        break;
                    }
                }
                if (czyZawieraMale == false){
                    textViewKomunikat.setText("Haslo nie zawiera malych liter");
                }
                for (int i=0; i<hasloCharArr.length; i++){
                    for (int j=0; j<duzeLitery.length; j++){
                        if (hasloCharArr[i] == duzeLitery[j]){
                            czyZawieraDuze = true;
                            break;
                        }
                    }
                    if (czyZawieraDuze == true){
                        break;
                    }
                }
                if (czyZawieraDuze == false){
                    textViewKomunikat.setText("Haslo nie zawiera duzych liter");
                }
                for (int i=0; i<hasloCharArr.length; i++){
                    for (int j=0; j<znakiSpecjalne.length; j++){
                        if (hasloCharArr[i] == znakiSpecjalne[j]){
                            czyZawieraZnaki = true;
                            break;
                        }
                    }
                    if (czyZawieraZnaki == true){
                        break;
                    }
                }
                if (czyZawieraZnaki == false){
                    textViewKomunikat.setText("Haslo nie zawiera znakow specjalnych");
                }
                for (int i=0; i<hasloCharArr.length; i++){
                    for (int j=0; j<liczby.length; j++){
                        if (hasloCharArr[i] == liczby[j]){
                            czyZawieraCyfry = true;
                            break;
                        }
                    }
                    if (czyZawieraCyfry == true){
                        break;
                    }
                }
                if (czyZawieraCyfry == false){
                    textViewKomunikat.setText("Haslo nie zawiera cyfr");
                }
                if (!haslo.equals(powtorzHaslo)){
                    textViewKomunikat.setText("Hasła się różnią");
                    bledy++;
                }
                else if (bledy == 0){
                    textViewKomunikat.setText("Witaj " + email);
                }
            }
        });
    }
}
