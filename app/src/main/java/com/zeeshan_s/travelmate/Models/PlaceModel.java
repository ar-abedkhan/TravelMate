package com.zeeshan_s.travelmate.Models;

public class PlaceModel {
    int p_id, rate;
    String name, description, full_location, place_img, place_district, category;

    public PlaceModel() {
    }

    public PlaceModel(int p_id, int rate, String name, String description, String full_location, String place_img, String place_district, String category) {
        this.p_id = p_id;
        this.rate = rate;
        this.name = name;
        this.description = description;
        this.full_location = full_location;
        this.place_img = place_img;
        this.place_district = place_district;
        this.category = category;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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

    public String getFull_location() {
        return full_location;
    }

    public void setFull_location(String full_location) {
        this.full_location = full_location;
    }

    public String getPlace_img() {
        return place_img;
    }

    public void setPlace_img(String place_img) {
        this.place_img = place_img;
    }

    public String getPlace_district() {
        return place_district;
    }

    public void setPlace_district(String place_district) {
        this.place_district = place_district;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
