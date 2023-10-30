package com.example.my_app_java_android.dto.category;

import android.graphics.drawable.Drawable;

public class CategoryCreateDTO {
    private String name;
    private Drawable image;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}