package com.springboothackathon.models;

public class Movie {
    private int id;
    private String name;
    private float rating;
    private String imageFile;
    private String genre;

    public Movie(int _id, String _name, float _rating, String _imageFile, String _genre){
        this.id = _id;
        this.name = _name;
        this.genre = _genre;
        this.imageFile = _imageFile;
        this.rating = _rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getImageFile() {
        return imageFile;
    }

    public float getRating() {
        return rating;
    }
}
