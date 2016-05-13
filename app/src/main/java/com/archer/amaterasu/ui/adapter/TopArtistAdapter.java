package com.archer.amaterasu.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.domain.Artist;
import com.archer.amaterasu.ui.holder.TopArtistViewHolder;

import java.util.ArrayList;

public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistViewHolder>{

    private Context context;
    private ArrayList<Artist> topArtistsArrayList;

    public TopArtistAdapter(Context context){
        this.context = context;
        this.topArtistsArrayList = new ArrayList<>();
    }

    @Override
    public TopArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_artist_row, parent, false);
        return new TopArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopArtistViewHolder holder, int position) {
        Artist currentArtist = topArtistsArrayList.get(position);
        holder.setArtistImage(currentArtist.getCover());
        holder.setArtistName(currentArtist.getName());
        holder.setArtistVotes(currentArtist.getVotes());
        holder.setArtistRating(currentArtist.getRating());
    }

    @Override
    public int getItemCount() {
        return topArtistsArrayList.size();
    }

    /**
     * Add item in the last index
     *
     * @param artist The item to be inserted
     */
    public void addItem(Artist artist) {
        if (artist == null)
            throw new NullPointerException("The item cannot be null");

        topArtistsArrayList.add(artist);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Add item in determined index
     *
     * @param artist    The event to be inserted
     * @param position Index for the new event
     */
    public void addItem(Artist artist, int position) {
        if (artist == null)
            throw new NullPointerException("The item cannot be null");

        if (position < getItemCount() || position > getItemCount())
            throw new IllegalArgumentException("The position must be between 0 and lastIndex + 1");

        topArtistsArrayList.add(position, artist);
        notifyItemInserted(position);
    }

    /**
     * Add a bunch of items
     *
     * @param artists Collection to add
     * */
    public void addAll(ArrayList<Artist> artists) {
        if (artists == null)
            throw new NullPointerException("The items cannot be null");

        this.topArtistsArrayList.addAll(artists);
        notifyItemRangeInserted(getItemCount() - 1, artists.size());
    }

    public void replace(ArrayList<Artist> artists){
        this.topArtistsArrayList = artists;
        notifyDataSetChanged();
    }

    /**
     * Delete all the items
     * */
    public void clear() {
        if (!topArtistsArrayList.isEmpty()) {
            topArtistsArrayList.clear();
            notifyDataSetChanged();
        }
    }
}














