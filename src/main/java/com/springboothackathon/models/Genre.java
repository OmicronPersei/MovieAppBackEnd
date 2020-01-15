package com.springboothackathon.models;

public class Genre {
    private int id;
    private String name;

    public Genre(int _id, String _name){
        this.id = _id;
        this.name = _name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
