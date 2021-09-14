package com.example.onlinegroceries.model;

import android.graphics.drawable.Drawable;

public class RecentlyViewed {

    String Name;
    String Description;
    String price;
    String quantity;
    String unit;
    Integer imageUrl;
    Integer begImageUrl;

    public RecentlyViewed(String name, String description, String price, String quantity, String unit, Integer imageUrl, Integer begImageUrl) {
        Name = name;
        Description = description;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.imageUrl = imageUrl;
        this.begImageUrl = begImageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getBegImageUrl() {
        return begImageUrl;
    }

    public void setBegImageUrl(Integer begImageUrl) {
        this.begImageUrl = begImageUrl;
    }
}
