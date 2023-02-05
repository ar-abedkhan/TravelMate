package com.zeeshan_s.travelmate.Models;

public class PlaceModel {
    public String placeName,placeLocation,placeRatings;
public int placeImg;

    public PlaceModel(String placeName, String placeLocation, String placeRatings, int placeImg) {
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placeRatings = placeRatings;
        this.placeImg = placeImg;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }

    public String getPlaceRatings() {
        return placeRatings;
    }

    public void setPlaceRatings(String placeRatings) {
        this.placeRatings = placeRatings;
    }

    public int getPlaceImg() {
        return placeImg;
    }

    public void setPlaceImg(int placeImg) {
        this.placeImg = placeImg;
    }
}
