package com.example.aplikasilaundry_a11202012754.database;

import com.example.aplikasilaundry_a11202012754.ModelLocation;
import com.google.gson.annotations.SerializedName;

public class ModelGeometry {
    @SerializedName("location")
    private ModelLocation modelLocation;

    public ModelLocation getModelLocation() {
        return modelLocation;
    }

    public void setModelLocation(ModelLocation modelLocation) {
        this.modelLocation = modelLocation;
    }
}
