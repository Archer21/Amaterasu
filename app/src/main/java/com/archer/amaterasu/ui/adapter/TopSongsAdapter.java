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
        if (currentSong.getSongImage() != null){
            holder.setImage(context, currentSong.getSongImage());
        } else{
            holder.setDefaultImage(context);
        }

        holder.setName(currentSong.getSongName());
        holder.setTopSongRating(currentSong.getSongRating());
        holder.setPlayCount(currentSong.getSongPlaycount());
        holder.setListeners(currentSong.getSongListeners());
    }

    @Override
    public int getItemCount() {
        return listSongs.size();
    }

    /**
     * Add item in the last index
     *
     * @param song The item to be inserted
     */
    public void addItem(Song song) {
        if (song == null)
            throw new NullPointerException("The item cannot be null");

        listSongs.add(song);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Add item in determined index
     *
     * @param song    The event to be inserted
     * @param position Index for the new event
     */
    public void addItem(Song song, int position) {
        if (song == null)
            throw new NullPointerException("The item cannot be null");

        if (position < getItemCount() || position > getItemCount())
            throw new IllegalArgumentException("The position must be between 0 and lastIndex + 1");

        listSongs.add(position, song);
        notifyItemInserted(position);
    }

    /**
     * Add a bunch of items
     *
     * @param artists Collection to add
     * */
    public void addAll(ArrayList<Song> artists) {
        if (artists == null)
            throw new NullPointerException("The items cannot be null");

        this.listSongs.addAll(artists);
        notifyItemRangeInserted(getItemCount() - 1, artists.size());
    }

    public void replace(ArrayList<Song> artists){
        this.listSongs = artists;
        notifyDataSetChanged();
    }

    /**
     * Delete all the items
     * */
    public void clear() {
        if (!listSongs.isEmpty()) {
            listSongs.clear();
            notifyDataSetChanged();
        }
    }

}



























