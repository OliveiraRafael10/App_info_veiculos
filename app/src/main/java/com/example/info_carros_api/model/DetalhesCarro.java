package com.example.info_carros_api.model;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

public class DetalhesCarro {
    @SerializedName("brand")
    private String brand;
    @SerializedName("model")
    private String model;
    @SerializedName("reference")
    private String reference;
    @SerializedName("years")
    private List<AnoModelo> years;

    public List<AnoModelo> getYears() {
        return years;
    }

    public void setYears(List<AnoModelo> years) {
        this.years = years;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
