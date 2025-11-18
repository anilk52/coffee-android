package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.MainActivity;
import com.example.coffee.R;
import com.example.coffee.data.RecipeData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Kategoriye göre tarif listesini gösteren ekran.
 * MainActivity'den gelen kategori koduna göre (espresso, filter, latte_lab vb.)
 * RecipeData içinden doğru listeyi çeker.
 */
public class RecipeActivity extends AppCompatActivity implements RecipeAdapter.OnRecipeClickListener {

    private RecyclerView recyclerRecipes;
    private TextView txtCategoryTitle;
    private TextView txtCategorySubtitle;

    private RecipeAdapter adapter;
    private List<Recipe> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recyclerRecipes     = findViewById(R.id.recyclerRecipes);
        txtCategoryTitle    = findViewById(R.id.txtCategoryTitle);
        txtCategorySubtitle = findViewById(R.id.txtCategorySubtitle);

        recyclerRecipes.setLayoutManager(new LinearLayoutManager(this));

        // MainActivity'den gelen kategori kodu
        String category = getIntent().getStringExtra(MainActivity.EXTRA_CATEGORY);
        if (category == null) {
            category = "espresso"; // güvenlik için varsayılan
        }

        // Başlık + tarif listesini kategoriden üret
        setupCategoryUi(category);
    }

    /**
     * Kategoriye göre başlığı ayarlar ve ilgili tarif listesini yükler.
     */
    private void setupCategoryUi(String category) {
        String title;
        String subtitle;

        switch (category) {
            case "espresso":
                title = "Espresso";
                subtitle = "Espresso shot ve espresso bazlı klasik tarifler.";
                recipeList = RecipeData.getEspressoRecipes();
                break;

            case "filter":
                title = "Filter";
                subtitle = "V60, Chemex, French Press ve diğer pour-over tarifleri.";
                recipeList = RecipeData.getFilterRecipes();
                break;

            case "latte_lab":
                title = "Latte Lab";
                subtitle = "Latte tabanlı yaratıcı tarifler ve şurup kombinasyonları.";
                recipeList = RecipeData.getLatteLabRecipes();
                break;

            case "iced":
                title = "Iced";
                subtitle = "Soğuk kahveler, cold brew ve buzlu tarifler.";
                recipeList = RecipeData.getIcedRecipes();
                break;

            case "turkish":
                title = "Turkish";
                subtitle = "Türk kahvesi ve cezve varyasyonları.";
                recipeList = RecipeData.getTurkishRecipes();
                break;

            case "alcoholic":
                title = "Alcoholic";
                subtitle = "Likör ve alkolle hazırlanan kahve kokteylleri.";
                recipeList = RecipeData.getAlcoholicRecipes();
                break;

            case "frappe":
                title = "Frappe";
                subtitle = "Blender veya shaker ile hazırlanan buzlu karışımlar.";
                recipeList = RecipeData.getFrappeRecipes();
                break;

            case "signature":
                title = "Signature";
                subtitle = "bdino° Coffee imza tarifleri.";
                recipeList = RecipeData.getSignatureRecipes();
                break;

            case "brew_guide":
                title = "Brew Guide";
                subtitle = "Öğütüm, oran ve sıcaklık için rehber notlar.";
                recipeList = RecipeData.getBrewGuideRecipes();
                break;

            default:
                // Bilinmeyen kategori gelirse espresso'ya düş
                title = "Espresso";
                subtitle = "Espresso shot ve espresso bazlı klasik tarifler.";
                recipeList = RecipeData.getEspressoRecipes();
                break;
        }

        if (txtCategoryTitle != null) {
            txtCategoryTitle.setText(title);
        }
        if (txtCategorySubtitle != null) {
            txtCategorySubtitle.setText(subtitle);
        }

        // Adapter’i bağla
        adapter = new RecipeAdapter(recipeList, this);
        recyclerRecipes.setAdapter(adapter);
    }

    /**
     * Bir tarif kartına tıklandığında detay ekranına geç.
     * RecipeAdapter.OnRecipeClickListener
     */
    @Override
    public void onRecipeClick(Recipe recipe) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        // Projede daha önce nasıl yaptıysak aynı şekilde:
        // Çoğunlukla "recipe" Serializable/Parcelable olarak gönderiyorduk.
        intent.putExtra("recipe", recipe);
        startActivity(intent);
    }
}