package com.archer.amaterasu.domain;

import java.util.HashMap;

/**
 * Created by archer on 18-12-16.
 */

public class Song {
    private int id;
    private int likes;

    private String title;
    private String artist;
    private String duration;
    private String year;
    private float  rating;

    private HashMap<Integer, String> images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public HashMap<Integer, String> getImages() {
        return images;
    }

    public void setImages(HashMap<Integer, String> images) {
        this.images = images;
    }
}



































