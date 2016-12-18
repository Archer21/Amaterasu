package com.archer.amaterasu.ui.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.archer.amaterasu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class HotSongAdapter extends RecyclerView.Adapter<HotSongAdapter.HotSongViewHolder>{

    @Override
    public HotSongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HotSongViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HotSongViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title_hot_song_item)
        TextView  title;
        @BindView(R.id.artist_hot_song_item)
        TextView  artist;
        @BindView(R.id.image_hot_song_item)
        CircleImageView image;
        @BindView(R.id.duration_hot_song_item)
        TextView  duration;
        @BindView(R.id.likes_hot_song_item)
        TextView  likes;


        public HotSongViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
//            ButterKnife.bind(this, itemView);
        }

        public void setTitle(String title) {
            this.title.setText(title);
        }

        public void setArtist(String artist) {
            this.artist.setText(artist);
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setDuration(String duration) {
            this.duration.setText(duration);
        }

        public void setLikes(int likes) {
            this.likes.setText(likes);
        }
    }


}
















































