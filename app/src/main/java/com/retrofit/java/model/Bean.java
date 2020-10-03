package com.retrofit.java.model;

import com.google.gson.annotations.SerializedName;

public class Bean {

    @SerializedName("_id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("pic")
    private String pic;

    @SerializedName("year")
    private int year;

    @SerializedName("month")
    private int month;

    @SerializedName("day")
    private int day;

    @SerializedName("des")
    private String des;

    @SerializedName("lunar")
    private String lunar;

    public Bean(String id, String title, String pic, int year, int month, int day, String des, String lunar) {
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.year = year;
        this.month = month;
        this.day = day;
        this.des = des;
        this.lunar = lunar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", des='" + des + '\'' +
                ", lunar='" + lunar + '\'' +
                '}';
    }
}
