package com.example.jerusalem.model;

import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("id")
    private Object id;

    @SerializedName("name")
    private String name;

    public Object getID() { return id; }

    public void setID(Object value) { this.id = value; }

    public String getName() { return name; }

    public void setName(String value) { this.name = value; }
}

