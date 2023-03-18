 package com.example.taller1_cm_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.taller1_cm_2023.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

 public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Integer counterButtonJuego = 0;
     private Integer counterButtonPaises = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String fecha = new SimpleDateFormat("EEE, MMMM dd, yyyy").format(new Date());

        binding.textViewFechaUsadoJuego.setText(fecha);
        binding.textViewFechaUsadoPaises.setText(fecha);


        binding.buttonJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counterButtonJuego++;
                binding.textViewNumVecesJuego.setText(counterButtonJuego.toString() + " veces");

                startActivity(new Intent(MainActivity.this, JuegoActivity.class));
            }
        });

        binding.buttonPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counterButtonPaises++;
                binding.textViewNumVecesPaises.setText(counterButtonPaises.toString() + " veces");

                startActivity(new Intent(MainActivity.this, PaisesActivity.class));
            }
        });

    }
}