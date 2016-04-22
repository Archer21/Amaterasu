package com.archer.amaterasu.io.callback;

import com.archer.amaterasu.domain.Song;

import java.util.ArrayList;

public interface SongsSearchServerCallback extends ServerCallback{
    void onSongsFound(ArrayList<Song> songs);

    void onFailedSearch();
}
