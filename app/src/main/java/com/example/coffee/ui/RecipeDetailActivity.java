package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;

public class RecipeDetailActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private CollapsingToolbarLayout collapsing;
    private ImageView imgHeader;
    private TextView txtContent;

    private String titleForShare = "";
    private String descForShare  = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        toolbar = findViewById(R.id.toolbar);
        collapsing = findViewById(R.id.collapsing);
        imgHeader = findViewById(R.id.imgHeader);
        txtContent = findViewById(R.id.txtContent);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Intent verileri
        String nameExtra = getIntent().getStringExtra("recipe_name");
        String descExtra = getIntent().getStringExtra("recipe_desc");

        Recipe recipe = null;
        if (!TextUtils.isEmpty(nameExtra)) {
            recipe = RecipesData.findByName(nameExtra);
        }

        String title = (recipe != null && !TextUtils.isEmpty(recipe.getName()))
                ? recipe.getName()
                : (!TextUtils.isEmpty(nameExtra) ? nameExtra : getString(R.string.app_name));
        collapsing.setTitle(title);
        titleForShare = title;

        String content = !TextUtils.isEmpty(descExtra) ? descExtra :
                (recipe != null && !TextUtils.isEmpty(recipe.getDescription()))
                        ? recipe.getDescription()
                        : "Afiyet olsun!";
        txtContent.setText(content);
        descForShare = content;

        if (recipe != null && recipe.getImageResId() != 0) {
            imgHeader.setImageResource(recipe.getImageResId());
        } else {
            imgHeader.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipe_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            Intent send = new Intent(Intent.ACTION_SEND);
            send.setType("text/plain");
            String body = titleForShare + "\n\n" + descForShare + "\n\n#BdinoCoffee";
            send.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(send, "Tarifi paylaş"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}