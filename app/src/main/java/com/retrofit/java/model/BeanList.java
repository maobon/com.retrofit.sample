package com.retrofit.java.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BeanList {

    @SerializedName("result")
    private ArrayList<Bean> beanList;

    public ArrayList<Bean> getBeanList() {
        return beanList;
    }

    public void setBeanList(ArrayList<Bean> beanList) {
        this.beanList = beanList;
    }
}
