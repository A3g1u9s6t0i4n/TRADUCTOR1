package com.example.traductor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.traductor.databinding.ActivitySegundaBinding;

public class segundaActivity extends AppCompatActivity {

    private ActivitySegundaBinding binding;
    private TraductorViewModel traductorViewModel;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundaBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        traductorViewModel = new ViewModelProvider(this).get(TraductorViewModel.class);
        String palEspanol = getIntent().getStringExtra("PalabraEsp");

        if (palEspanol != null){
            traductorViewModel.TraducirPalabra(palEspanol);
        }

        traductorViewModel.getPalabraTraducida().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String palabra) {
                binding.etIngles.setText(palabra);

            }
        });

        traductorViewModel.getImagen().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer imagen) {
                binding.img.setImageResource(imagen);

            }
        });



        binding.btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(segundaActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}