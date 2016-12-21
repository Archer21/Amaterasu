package com.archer.amaterasu.io.model;

import com.archer.amaterasu.domain.Song;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by archer on 20-12-16.
 */

public class SongResponse {

    SongResults results;

    public List<Song> getSongs () {
        return results.songs;
    }

    public void setSongs (List<Song> songs) {
        results.songs = songs;
    }

    public class SongResults {
        List<Song> songs;
    }
}






























