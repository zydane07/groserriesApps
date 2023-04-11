package com.example.groceriesapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.groceriesapps.adapter.CategoryAdapter;
import com.example.groceriesapps.adapter.DiscountedProductsAdapter;
import com.example.groceriesapps.adapter.RecentlyViewedAdapter;
import com.example.groceriesapps.model.Category;
import com.example.groceriesapps.model.DiscountedProducts;
import com.example.groceriesapps.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecyclerView;

    DiscountedProductsAdapter discountedProductsAdapter;
    List<DiscountedProducts> discountedProductsList;

    TextView allCategory;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        recentlyViewedRecyclerView = findViewById(R.id.recentlyItemRecycler);
        allCategory = findViewById(R.id.showAllCategory);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllCategory.class);
                startActivity(intent);
            }
        });


        // adding data to model
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2, R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3, R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(4, R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(5, R.drawable.discountmeat));

        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.ic_home_fish));
        categoryList.add(new Category(2, R.drawable.ic_home_fruits));
        categoryList.add(new Category(3, R.drawable.ic_home_vegies));
        categoryList.add(new Category(4, R.drawable.ic_home_meats));
        categoryList.add(new Category(5, R.drawable.ic_home_fish));
        categoryList.add(new Category(6, R.drawable.ic_home_fruits));
        categoryList.add(new Category(7, R.drawable.ic_home_vegies));
        categoryList.add(new Category(8, R.drawable.ic_home_meats));

        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Melon", "Melon adalah buah melon yang hijau", "Rp.13.000","1", "10", R.drawable.card1, R.drawable.b1));
        recentlyViewedList.add(new RecentlyViewed("Strawberry", "Strawberry adalah buah strawberry yang merah", "Rp.18.000","5", "20", R.drawable.card2, R.drawable.b2));
        recentlyViewedList.add(new RecentlyViewed("Papaya", "Papaya adalah buah papaya yang orange", "Rp.10.000","6", "20", R.drawable.card3, R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Watermelon", "Watermelon adalah buah semangka yang merah", "Rp.20.000","15", "18", R.drawable.card4, R.drawable.b4));


        setDiscountRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

        Log.d("MainActivity", "Hello fsfs");

    }
    private void setDiscountRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductsAdapter = new DiscountedProductsAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductsAdapter);
    }

    private void setCategoryRecycler(List<Category> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,dataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecyclerView.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecyclerView.setAdapter(recentlyViewedAdapter);
    }
}