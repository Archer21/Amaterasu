package com.archer.amaterasu.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.domain.ListSong;
import com.archer.amaterasu.ui.holder.FavoritesListSongsViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FavoritesSongListAdapter extends RecyclerView.Adapter<FavoritesListSongsViewHolder> {

    private Context context;
    private List<ListSong> listSongs;

    public FavoritesSongListAdapter(Context context) {
        this.context = context;
        this.listSongs = new ArrayList<>();
    }

    public void addAll(List<ListSong> list) {
        if (list == null)
            throw new NullPointerException("The items cannot be null");

        this.listSongs.addAll(list);
        notifyItemRangeInserted(getItemCount() - 1, list.size());
    }

    @Override
    public FavoritesListSongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorite_song_row, parent, false);
        return new FavoritesListSongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoritesListSongsViewHolder holder, int position) {
        ListSong currentList = listSongs.get(position);
        holder.setListImage(currentList.getSongs().get(0).getSongImageSmall());
        holder.setListName(currentList.getName());
    }

    @Override
    public int getItemCount() {
        return listSongs.size();
    }
}











