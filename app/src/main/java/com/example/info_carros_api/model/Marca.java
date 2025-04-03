package com.example.info_carros_api.model;

import com.google.gson.annotations.SerializedName;

public class Marca {
    @SerializedName("id")
    private String id;
    @SerializedName("brand")
    private String brand;

    public Marca(String id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }
}
