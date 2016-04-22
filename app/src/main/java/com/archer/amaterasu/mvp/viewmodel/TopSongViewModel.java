package com.archer.amaterasu.mvp.viewmodel;

import com.archer.amaterasu.domain.Song;

import java.util.ArrayList;

public interface TopSongViewModel {
    void setupList();

    void setupAdapter();

    void displayFoundSongs(ArrayList<Song> songs);

    void displayFailedSearch();

    void displayNetworkError();

    void displayServerError();
}
