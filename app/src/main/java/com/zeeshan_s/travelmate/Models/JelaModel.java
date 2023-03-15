package com.zeeshan_s.travelmate.Models;

public class JelaModel {
    public String jelaName;
    public int jelaImg;
    public String placeName, placeLocation, placeRatings;
    public int placeImg;


    public JelaModel(String jelaName, int jelaImg, String placeName, String placeLocation, String placeRatings, int placeImg) {
        this.jelaName = jelaName;
        this.jelaImg = jelaImg;
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placeRatings = placeRatings;
        this.placeImg = placeImg;
    }


    public String getJelaName() {
        return jelaName;
    }

    public void setJelaName(String jelaName) {
        this.jelaName = jelaName;
    }

    public int getJelaImg() {
        return jelaImg;
    }

    public void setJelaImg(int jelaImg) {
        this.jelaImg = jelaImg;
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