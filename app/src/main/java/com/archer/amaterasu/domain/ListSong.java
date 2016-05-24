package com.archer.amaterasu.domain;

import io.realm.RealmList;
import io.realm.RealmObject;

public class ListSong extends RealmObject{
    public String name;
    public RealmList<Song> songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Song> getSongs() {
        return songs;
    }

    public void setSongs(RealmList<Song> songs) {
        this.songs = songs;
    }
}






















