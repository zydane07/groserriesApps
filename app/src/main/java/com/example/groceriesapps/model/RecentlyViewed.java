package com.example.groceriesapps.model;

import android.graphics.drawable.Drawable;

public class RecentlyViewed {
    String name;
    String description;
    String Price;
    String quantity;
    String unit;
    int imageUrl;
    int bigImageUrl;

    public RecentlyViewed(String name, String description, String price, String quantity, String unit, int imageUrl, int bigImageUrl) {
        this.name = name;
        this.description = description;
        Price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.imageUrl = imageUrl;
        this.bigImageUrl = bigImageUrl;
    }

    public int getBigImageUrl() {
        return bigImageUrl;
    }

    public void setBigImageUrl(int bigImageUrl) {
        this.bigImageUrl = bigImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
