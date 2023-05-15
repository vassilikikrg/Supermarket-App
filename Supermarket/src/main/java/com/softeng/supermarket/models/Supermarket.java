package com.softeng.supermarket.models;

public class Supermarket {
    private String Id;
    private String Name;
    private String Location;    //must change
    private String Info;

    public Supermarket(String id, String name, String location, String info) {
        Id = id;
        Name = name;
        Location = location;
        Info = info;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }
}
