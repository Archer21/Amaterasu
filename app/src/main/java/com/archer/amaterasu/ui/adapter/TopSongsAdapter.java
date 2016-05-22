package com.archer.amaterasu.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.archer.amaterasu.R;
import com.archer.amaterasu.domain.Song;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsAdapter.TopSongsViewHolder> {

    ArrayList<Song> listSongs;
    Context context;
    OnItemClickListener listener;


    public TopSongsAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listSongs = new ArrayList<>();
        this.listener = listener;
    }

    @Override
    public TopSongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_song_row, parent, false);
        return new TopSongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopSongsViewHolder holder, int position) {
        Song currentSong = listSongs.get(position);

        holder.setImage(context, currentSong.getSongImageSmall());
        holder.setName(currentSong.getSongTitle());
        holder.setTopSongRating(currentSong.getSongRating());
        holder.setPlayCount(currentSong.getSongViews());
        holder.bind(listSongs.get(position), listener);
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


    public Song getItemAtPosition(int position){
        return listSongs.get(position);
    }

    public interface OnItemClickListener {
        void onItemClick(Song item);
    }

    public class TopSongsViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.top_song_image)
        SimpleDraweeView topSongImage;
        @Bind(R.id.top_song_name)
        TextView topSongName;
        @Bind(R.id.top_song_rating)
        TextView topSongRating;
        @Bind(R.id.top_song_playcount)
        TextView  topSongPlaycount;
//    @Bind(R.id.top_song_listeners)
//    TextView  topSongListeners;

        public TopSongsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//        Drawable progress = topSongRating.getProgressDrawable();
//        DrawableCompat.setTint(progress, Color.rgb(255,50,120));
        }

        public void setImage(Context context, String urlImage){
            Uri uri = Uri.parse(urlImage);
            topSongImage.setImageURI(uri);
        }

        public void setName(String name){
            this.topSongName.setText(name);
        }

        public void setTopSongRating(float rating){
            this.topSongRating.setText(rating + "");
        }
        public void setPlayCount(int playCount){
            this.topSongPlaycount.setText(playCount + "");
        }

        public void bind(final Song item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}



























