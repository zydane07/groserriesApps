package com.example.groceriesapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.example.groceriesapps.adapter.AllCategoryAdapter;
import com.example.groceriesapps.model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {
    RecyclerView allCategoryRecycler;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategoryModel> categoryModelList;

    ImageView backMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        allCategoryRecycler = findViewById(R.id.allCategoryRecycler);

        backMenu = findViewById(R.id.backMenu);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllCategory.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // adding data to model
        categoryModelList = new ArrayList<>();
        categoryModelList.add(new AllCategoryModel(1, R.drawable.ic_fruits));
        categoryModelList.add(new AllCategoryModel(2, R.drawable.ic_veggies));
        categoryModelList.add(new AllCategoryModel(3, R.drawable.ic_meat));
        categoryModelList.add(new AllCategoryModel(4, R.drawable.ic_fish));
        categoryModelList.add(new AllCategoryModel(5, R.drawable.ic_spices));
        categoryModelList.add(new AllCategoryModel(6, R.drawable.ic_egg));
        categoryModelList.add(new AllCategoryModel(7, R.drawable.ic_drink));
        categoryModelList.add(new AllCategoryModel(8, R.drawable.ic_cookies));
        categoryModelList.add(new AllCategoryModel(9, R.drawable.ic_juce));

        setAllCategoryRecycler (categoryModelList);

    }

    private void setAllCategoryRecycler(List<AllCategoryModel> categoryModelList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        allCategoryRecycler.setLayoutManager(layoutManager);
        allCategoryAdapter = new AllCategoryAdapter(this, categoryModelList);
        allCategoryRecycler.setAdapter(allCategoryAdapter);
    }


}