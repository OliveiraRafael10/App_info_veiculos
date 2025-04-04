package com.example.info_carros_api.model;

import com.google.gson.annotations.SerializedName;

public class CarroMarca {
    @SerializedName("id")
    private String id;
    @SerializedName("fipe_code")
    private String fipe_code;
    @SerializedName("model")
    private String model;
    @SerializedName("years")
    private String years;

    public CarroMarca(String id, String fipe_code, String model, String years) {
        this.id = id;
        this.fipe_code = fipe_code;
        this.model = model;
        this.years = years;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFipe_code() {
        return fipe_code;
    }

    public void setFipe_code(String fipe_code) {
        this.fipe_code = fipe_code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
}
