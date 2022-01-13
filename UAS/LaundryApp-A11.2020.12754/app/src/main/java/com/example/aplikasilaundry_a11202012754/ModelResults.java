package com.example.aplikasilaundry_a11202012754;

import com.example.aplikasilaundry_a11202012754.database.ModelGeometry;
import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Annotation;

public class ModelResults implements SerializedName {

    @SerializedName("geometry")
    private ModelGeometry modelGeometry;

    @SerializedName("name")
    private String name;

    @SerializedName("vicinity")
    private String vicinity;

    @SerializedName("place_id")
    private String placeId;

    @SerializedName("rating")
    private double rating;

    public ModelGeometry getModelGeometry() {
        return modelGeometry;
    }

    public void setModelGeometry(ModelGeometry modelGeometry) {
        this.modelGeometry = modelGeometry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getRating() {
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public String[] alternate() {
        return new String[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
