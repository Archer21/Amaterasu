package com.archer.amaterasu.domain;

public class Song {
    private int    songPlaycount;
    private int    songListeners;
    private float  songRating;
    private String songName;
    private String songImage;

    public int getSongPlaycount() {
        return songPlaycount;
    }

    public void setSongPlaycount(int songPlaycount) {
        this.songPlaycount = songPlaycount;
    }

    public int getSongListeners() {
        return songListeners;
    }

    public void setSongListeners(int songListeners) {
        this.songListeners = songListeners;
    }

    public float getSongRating() {
        return songRating;
    }

    public void setSongRating(float songRating) {
        this.songRating = songRating;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongImage() {
        return songImage;
    }

    public void setSongImage(String songImage) {
        this.songImage = songImage;
    }
}
