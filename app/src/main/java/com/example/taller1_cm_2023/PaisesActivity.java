package com.example.taller1_cm_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.taller1_cm_2023.databinding.ActivityPaisesBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PaisesActivity extends AppCompatActivity {

    private ActivityPaisesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<String> countriesArray = new ArrayList<String>();
        List<String> capitolsArray = new ArrayList<String>();
        List<String> codesArray = new ArrayList<String>();
        List<String> flagUrlsArray = new ArrayList<String>();

        try {
            JSONObject jsonFile = loadJSONFromAsset();
            JSONArray countries = jsonFile.getJSONArray("Countries");
            for (int i = 0; i < countries.length(); i++) {
                countriesArray.add(countries.getJSONObject(i).getString("Name"));
                capitolsArray.add(countries.getJSONObject(i).getString("Region"));
                codesArray.add(countries.getJSONObject(i).getString("Alpha3Code"));
                flagUrlsArray.add(countries.getJSONObject(i).getString("FlagPng"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapterListView = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, countriesArray);
        binding.paisesListView.setAdapter(adapterListView);
        binding.paisesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),String.format("Posición en la lista: %S", position),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(PaisesActivity.this, DetallePaisActivity.class);
                intent.putExtra("nombre_pais", countriesArray.get(position));
                intent.putExtra("capital", capitolsArray.get(position));
                intent.putExtra("codigo", codesArray.get(position));
                intent.putExtra("flagUrl", flagUrlsArray.get(position));

                startActivity(intent);
            }
        });
    }

    private JSONObject loadJSONFromAsset() throws JSONException {
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return new JSONObject(json);
    }
}