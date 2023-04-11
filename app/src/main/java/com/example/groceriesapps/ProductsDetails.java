package com.example.groceriesapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductsDetails extends AppCompatActivity {
    ImageView img, back;
    TextView proName, proPrice, proDesc;

    String name, price, desc;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_details);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        image = intent.getIntExtra("image", R.drawable.b1);
        price = intent.getStringExtra("price");
        desc = intent.getStringExtra("description");

        proName = findViewById(R.id.product_title);
        proPrice = findViewById(R.id.product_price);
        proDesc = findViewById(R.id.product_description);
        img = findViewById(R.id.big_image);
        back = findViewById(R.id.backMenu2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductsDetails.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        img.setImageResource(image);


    }
}