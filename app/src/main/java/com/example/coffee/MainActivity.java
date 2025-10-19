package com.example.coffee;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    TextView tv = new TextView(this);
    tv.setText("Coffee Demo\n\nEspresso 18g -> 36g (25-30s)\nAmericano 1 shot + 120-150ml hot water\nCappuccino 1:1:1 espresso:milk:foam");
    tv.setGravity(Gravity.CENTER);
    tv.setTextSize(18);

    setContentView(tv);
  }
}
