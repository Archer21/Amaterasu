package com.archer.amaterasu.ui.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.archer.amaterasu.R;
import com.archer.amaterasu.domain.Song;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class HotSongAdapter extends RecyclerView.Adapter<HotSongAdapter.HotSongViewHolder>{

    private Context context;
    private List<Song> songs;
    private OnItemClickListener listener;

    public HotSongAdapter(Context context, OnItemClickListener listener) {
        this.context  = context;
        this.songs    = new ArrayList<>();
        this.listener = listener;
    }

    /**
     * Add item in the last index
     *
     * @param song The item to be inserted
     */
    public void addItem(Song song) {
        if (song == null)
            throw new NullPointerException("The item cannot be null");

        songs.add(song);
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

        songs.add(position, song);
        notifyItemInserted(position);
    }

    /**
     * Add a bunch of items
     *
     * @param songs Collection to add
     * */
    public void addAll(List<Song> songs) {
        if (songs == null)
            throw new NullPointerException("The items cannot be null");

        this.songs.addAll(songs);
        notifyItemRangeInserted(getItemCount() - 1, songs.size());
    }

    public void replace(ArrayList<Song> songs){
        this.songs = songs;
        notifyDataSetChanged();
    }

    /**
     * Delete all the items
     * */
    public void clear() {
        if (!songs.isEmpty()) {
            songs.clear();
            notifyDataSetChanged();
        }
    }


    /**
     * RecyclerView.Adapter OVERRIDED METHODS
     */

    @Override
    public HotSongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hot_song, parent, false);
        return new HotSongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HotSongViewHolder holder, int position) {
        Song currentSong = songs.get(position);

        holder.setTitle(currentSong.getTitle());
        holder.setArtist(currentSong.getArtist());
        holder.setCover(currentSong.getImages().get(0));
        holder.setDuration(currentSong.getDuration());
        holder.setLikes(currentSong.getLikes());
        holder.bind(songs.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return songs.isEmpty() ? 0 : songs.size();
    }


    /**
     * OnItemClick interface
     */

    public interface OnItemClickListener {
        void onItemClick (Song item);
    }

    /**
     * VIEWHOLDER FOR SONGS
     */

    class HotSongViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title_hot_song_item)
        TextView  title;
        @BindView(R.id.artist_hot_song_item)
        TextView  artist;
        @BindView(R.id.image_hot_song_item)
        CircleImageView cover;
        @BindView(R.id.duration_hot_song_item)
        TextView  duration;
        @BindView(R.id.likes_hot_song_item)
        TextView  likes;


        public HotSongViewHolder(View itemView) {
            super(itemView);
//            ButterKnife.bind(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setTitle(String title) {
            this.title.setText(title);
        }

        public void setArtist(String artist) {
            this.artist.setText(artist);
        }

        public void setCover (String urlImage) {
            Picasso.with(context)
                    .load(urlImage)
                    .placeholder(R.drawable.placeholder_image)
                    .into(cover);
        }

        public void setDuration(String duration) {
            this.duration.setText(duration);
        }

        public void setLikes(int likes) {
            this.likes.setText(likes + "");
        }

        /**
         * item click listener for individual views
         */

        public void bind (final Song item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
















































