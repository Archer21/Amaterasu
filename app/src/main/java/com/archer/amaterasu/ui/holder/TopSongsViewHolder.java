package com.archer.amaterasu.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.archer.amaterasu.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopSongsViewHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.top_song_image)
    ImageView topSongImage;

    public TopSongsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public void setTopSongImage(){
        Picasso.with()
    }
}
