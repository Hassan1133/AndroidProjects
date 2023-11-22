package com.example.myfirstproject;

public class Courses {
    private int mainImg,icon;
    private String heading;
    private String details;

    public Courses(int mainImg, int icon, String heading, String details) {
        this.mainImg = mainImg;
        this.icon = icon;
        this.heading = heading;
        this.details = details;
    }

    public int getMainImg() {
        return mainImg;
    }

    public int getIcon() {
        return icon;
    }

    public String getHeading() {
        return heading;
    }

    public String getDetails() {
        return details;
    }
}
