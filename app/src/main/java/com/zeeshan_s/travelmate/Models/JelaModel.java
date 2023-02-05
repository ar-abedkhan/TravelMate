package com.zeeshan_s.travelmate.Models;

public class JelaModel {
    public String jelaName;
    public int jelaImg;

    public JelaModel(String jelaName, int jelaImg) {
        this.jelaName = jelaName;
        this.jelaImg = jelaImg;
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
}

