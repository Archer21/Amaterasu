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

    /**
     * Add item in the last index
     *
     * @param songs The item to be inserted
     */
    public void addItem(ListSong songs) {
        if (songs == null)
            throw new NullPointerException("The item cannot be null");

        listSongs.add(songs);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Add item in determined index
     *
     * @param songs    The event to be inserted
     * @param position Index for the new event
     */
    public void addItem(ListSong songs, int position) {
        if (songs == null)
            throw new NullPointerException("The item cannot be null");

        if (position < getItemCount() || position > getItemCount())
            throw new IllegalArgumentException("The position must be between 0 and lastIndex + 1");

        listSongs.add(position, songs);
        notifyItemInserted(position);
    }


    public void replace(List<ListSong> songs){
        this.listSongs = songs;
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


    @Override
    public FavoritesListSongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorite_list_song_row, parent, false);
        return new FavoritesListSongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoritesListSongsViewHolder holder, int position) {
        ListSong currentList = listSongs.get(position);

        if(currentList.getSongs() != null){
            if(currentList.getListSize() > 0){
                holder.setListImage(context, currentList.getSongs().get(0).getSongImageSmall());
            }
        } else {
            holder.setEmptyImage(context);
        }

        holder.setListName(currentList.getName());
        holder.setListSize(currentList.getListSize());
    }

    @Override
    public int getItemCount() {
        return listSongs.size();
    }
}











