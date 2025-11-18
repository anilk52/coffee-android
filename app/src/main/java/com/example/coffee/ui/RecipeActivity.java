package com.example.coffee.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;

import com.example.coffee.MainActivity;
import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Kategoriye göre tarif listesini gösteren ekran.
 * MainActivity'den gelen kategori koduna göre (espresso, filter, latte_lab vb.)
 * RecipesData içinden doğru listeyi çeker.
 */
public class RecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerRecipes;
    private TextView txtCategoryTitle;
    private TextView txtCategorySubtitle;

    private RecipeAdapter adapter;
    private List<Recipe> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // XML dosyanın ismi neyse onu kullan:
        // activity_recipe.xml ise:
        setContentView(R.layout.activity_recipe);
        // Eğer senin dosyan "activity_recipes.xml" ise yukarıyı şu yap:
        // setContentView(R.layout.activity_recipes);

        recyclerRecipes     = findViewById(R.id.recyclerRecipes);
        txtCategoryTitle    = findViewById(R.id.txtCategoryTitle);
        txtCategorySubtitle = findViewById(R.id.txtCategorySubtitle);

        recyclerRecipes.setLayoutManager(new LinearLayoutManager(this));

        // MainActivity'den gelen kategori kodu
        String category = getIntent().getStringExtra(MainActivity.EXTRA_CATEGORY);
        if (category == null) {
            category = "espresso"; // güvenlik için varsayılan
        }

        // Kategoriye göre başlık + listeyi doldur
        setupCategoryUi(category);
    }

    /**
     * Kategoriye göre başlığı ayarlar ve ilgili tarif listesini yükler.
     */
    private void setupCategoryUi(String category) {
        // RecipesData içindeki okunabilir isim
        String title = RecipesData.categoryLabel(category);
        String subtitle;

        switch (category) {
            case "espresso":
                subtitle = "Espresso shot ve espresso bazlı klasik tarifler.";
                break;
            case "filter":
                subtitle = "V60, Chemex, French Press ve diğer pour-over tarifleri.";
                break;
            case "latte_lab":
                subtitle = "Latte tabanlı yaratıcı tarifler ve şurup kombinasyonları.";
                break;
            case "iced":
                subtitle = "Soğuk kahveler, cold brew ve buzlu tarifler.";
                break;
            case "turkish":
                subtitle = "Türk kahvesi ve cezve varyasyonları.";
                break;
            case "alcoholic":
                subtitle = "Likör ve alkolle hazırlanan kahve kokteylleri.";
                break;
            case "frappe":
                subtitle = "Blender veya shaker ile hazırlanan buzlu karışımlar.";
                break;
            case "signature":
                subtitle = "bdino° Coffee imza tarifleri.";
                break;
            case "brew_guide":
                subtitle = "Öğütüm, oran ve sıcaklık için pratik demleme rehberleri.";
                break;
            default:
                subtitle = "Kahve dünyasını keşfetmek için seçtiğin kategori.";
                break;
        }

        if (txtCategoryTitle != null) {
            txtCategoryTitle.setText(title);
        }
        if (txtCategorySubtitle != null) {
            txtCategorySubtitle.setText(subtitle);
        }

        // Asıl önemli kısım: yeni veri katmanı
        recipeList = RecipesData.getByCategory(category);

        // DİKKAT: Burada sırayı düzelttik: (Context, List<Recipe>)
        adapter = new RecipeAdapter(this, recipeList);
        recyclerRecipes.setAdapter(adapter);
    }
}