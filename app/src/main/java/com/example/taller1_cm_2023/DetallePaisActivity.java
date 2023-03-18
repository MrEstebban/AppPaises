package com.example.taller1_cm_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebViewClient;

import com.bumptech.glide.Glide;
import com.example.taller1_cm_2023.databinding.ActivityDetallePaisBinding;

public class DetallePaisActivity extends AppCompatActivity {

    private ActivityDetallePaisBinding binding;
    private String nombrePais;
    private String capital;
    private String codigo;
    private String flagUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetallePaisBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        nombrePais = getIntent().getStringExtra("nombre_pais");
        capital = getIntent().getStringExtra("capital");
        codigo = getIntent().getStringExtra("codigo");
        flagUrl = getIntent().getStringExtra("flagUrl");

        //Nombre pais
        binding.paisTextView.setText(nombrePais);

        //Nombre capital
        binding.capitalTextView.setText(capital);

        //Nombre internacional
        binding.ciTextView.setText(nombrePais);

        //Siglas
        binding.siglaTextView.setText(codigo);

        Log.i("DetallePaisActivity", flagUrl);
        //Bandera
        Glide.with(this).load(flagUrl).into(binding.imageView);

    }
}