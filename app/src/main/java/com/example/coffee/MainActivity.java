package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.databinding.ActivityMainBinding;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnEspresso.setOnClickListener(v ->
                openCategory("Espresso Bazlı"));

        binding.btnFilter.setOnClickListener(v ->
                openCategory("Filtre Kahve"));

        binding.btnAlcohol.setOnClickListener(v ->
                openCategory("Alkollü Kahve"));
    }

    private void openCategory(String category) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("category", category);
        startActivity(i);
    }
}