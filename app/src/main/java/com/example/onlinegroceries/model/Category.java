package com.example.onlinegroceries.model;

public class Category {

    Integer ID;
    int imageUrl;

    public Category(Integer ID, int imageUrl) {
        this.ID = ID;
        this.imageUrl = imageUrl;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
