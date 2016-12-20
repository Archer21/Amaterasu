package com.archer.amaterasu.mvp.viewmodel;

import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.ui.adapter.HotSongAdapter;

import java.util.List;

/**
 * Created by archer on 20-12-16.
 */

public interface HotSongsViewModel {
    void setupList ();
    void setupAdapter (List<Song> songs);
}
