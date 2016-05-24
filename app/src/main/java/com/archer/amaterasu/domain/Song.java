package com.archer.amaterasu.domain;

import org.parceler.Parcel;

import io.realm.RealmObject;

@Parcel
public class Song extends RealmObject{
    public  int    id;
    public int    songViews;
    public float  songRating;
    public String songTitle;
    public String songArtist;
    public String songImageSmall;
    public String songImageMedium;
//    private int    songPlaycount;
//
//    public int getSongPlaycount() {
//        return songPlaycount;
//    }
//
//    public void setSongPlaycount(int songPlaycount) {
//        this.songPlaycount = songPlaycount;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSongViews() {
        return songViews;
    }

    public void setSongViews(int songViews) {
        this.songViews = songViews;
    }

    public float getSongRating() {
        return songRating;
    }

    public void setSongRating(float songRating) {
        this.songRating = songRating;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getSongImageSmall() {
        return songImageSmall;
    }

    public void setSongImageSmall(String songImageSmall) {
        this.songImageSmall = songImageSmall;
    }

    public String getSongImageMedium() {
        return songImageMedium;
    }

    public void setSongImageMedium(String songImageMedium) {
        this.songImageMedium = songImageMedium;
    }
}
