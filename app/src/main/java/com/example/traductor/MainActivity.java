package com.example.traductor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.traductor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btTraducir.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v){
               Intent intent = new Intent(MainActivity.this,segundaActivity.class);
               intent.putExtra("PalabraEsp",binding.etEspanol.getText().toString());
               startActivity(intent);
           }


        });
    }
}