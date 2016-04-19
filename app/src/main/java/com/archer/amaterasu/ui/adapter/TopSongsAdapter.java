package com.archer.amaterasu.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.ui.holder.TopSongsViewHolder;

import java.util.ArrayList;

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsViewHolder> {

    ArrayList<Song> listSongs;
    Context context;

    public TopSongsAdapter(Context context) {
        this.context = context;
        this.listSongs = new ArrayList<>();
    }

    @Override
    public TopSongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_song_row, parent, false);
        return new TopSongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopSongsViewHolder holder, int position) {
        Song currentSong = listSongs.get(position);
        holder.setImage(context, currentSong.getSongImage(), holder.getimageContainer(), currentSong);
    }

    @Override
    public int getItemCount() {
        return listSongs.size();
    }
}



























