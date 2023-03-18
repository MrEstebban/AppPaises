package com.example.taller1_cm_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.taller1_cm_2023.databinding.ActivityJuegoBinding;

import java.util.concurrent.ThreadLocalRandom;

public class JuegoActivity extends AppCompatActivity {

    private ActivityJuegoBinding binding;
    private Integer randomNumber;
    private Integer numIntentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJuegoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        randomNumber = ThreadLocalRandom.current().nextInt(0, 50 + 1);
        numIntentos = 1;

        binding.adivinarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer numero_ingresado = Integer.parseInt(binding.editTextNumber.getText().toString());
                String mensaje = "";

                if(numero_ingresado > randomNumber){
                    mensaje = "El número es menor";
                    numIntentos++;
                }else if(numero_ingresado < randomNumber){
                    mensaje = "El número es mayor";
                    numIntentos++;
                }else{
                    mensaje = "¡Correcto! 🤑 Adivinaste en " + numIntentos.toString() + " intentos";
                }

                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });



    }
}