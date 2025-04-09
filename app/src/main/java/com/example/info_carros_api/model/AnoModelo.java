package com.example.info_carros_api.model;

import com.google.gson.annotations.SerializedName;

public class AnoModelo {
    @SerializedName("year_id")
    private String year_id;
    @SerializedName("model_year")
    private String model_year;
    @SerializedName("fuel")
    private String fuel;
    @SerializedName("price")
    private int price;

    // Construtor padrão
    public AnoModelo() {}

    // Getters e setters
    public String getYear_id() {
        return year_id;
    }

    public void setYear_id(String year_id) {
        this.year_id = year_id;
    }

    public String getModel_year() {
        return model_year;
    }

    public void setModel_year(String model_year) {
        this.model_year = model_year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}