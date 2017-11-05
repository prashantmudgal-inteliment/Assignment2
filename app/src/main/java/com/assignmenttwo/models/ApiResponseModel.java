package com.assignmenttwo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by prashant.mudgal on 11/2/2017.
 */

public class ApiResponseModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fromcentral")
    @Expose
    private FromCentralModel fromcentral;
    @SerializedName("location")
    @Expose
    private LocationModel location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FromCentralModel getFromcentral() {
        return fromcentral;
    }

    public void setFromcentral(FromCentralModel fromcentral) {
        this.fromcentral = fromcentral;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ApiResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fromcentral=" + fromcentral +
                ", location=" + location +
                '}';
    }
}
