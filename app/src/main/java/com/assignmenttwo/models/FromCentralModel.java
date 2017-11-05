package com.assignmenttwo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by prashant.mudgal on 11/2/2017.
 */

public class FromCentralModel {
    @SerializedName("car")
    @Expose
    private String car;
    @SerializedName("train")
    @Expose
    private String train;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "FromCentralModel{" +
                "car='" + car + '\'' +
                ", train='" + train + '\'' +
                '}';
    }
}
