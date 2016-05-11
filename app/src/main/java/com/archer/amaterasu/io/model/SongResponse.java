package com.archer.amaterasu.io.model;

import com.archer.amaterasu.domain.Song;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SongResponse {

    @SerializedName(SongKeys.SONGS_RESULTS)
    SongResult results;

    public ArrayList<Song> getSongs(){
        return results.songs;
    }

    public void setSongs(ArrayList<Song> songs){
        results.songs = songs;
    }

    public class SongResult{
        ArrayList<Song> songs;
    }
}














