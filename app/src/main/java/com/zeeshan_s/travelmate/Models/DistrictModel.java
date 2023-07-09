package com.zeeshan_s.travelmate.Models;

public class DistrictModel {
    String name, img;
    int d_id;

    public DistrictModel() {
    }

    public DistrictModel( int d_id, String name, String img) {
        this.name = name;
        this.img = img;
        this.d_id = d_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }
}
