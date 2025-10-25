package com.example.coffee;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.coffee.databinding.ActivityMainBinding;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CoffeeAdapter.OnCoffeeClickListener {
    private ActivityMainBinding binding;
    private CoffeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<String> coffees = Arrays.asList(
                "Türk Kahvesi","Americano","Latte","Cappuccino","Mocha","Flat White","Macchiato"
        );

        adapter = new CoffeeAdapter(coffees, this);
        RecyclerView rv = binding.recyclerView;
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    @Override
    public void onCoffeeClick(String name) {
        Toast.makeText(this, name + " seçildi", Toast.LENGTH_SHORT).show();
    }
}
