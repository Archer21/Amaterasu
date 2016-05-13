package com.archer.amaterasu.domain;

import java.util.ArrayList;

public class ListSong {
    private String name;
    private ArrayList<Song> songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
