package com.archer.amaterasu.ui.holder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.archer.amaterasu.R;
import com.squareup.picasso.Picasso;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TopSongsViewHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.top_song_image)
    ImageView topSongImage;
    @Bind(R.id.top_song_name)
    TextView  topSongName;
    @Bind(R.id.top_song_rating)
    RatingBar topSongRating;
    @Bind(R.id.top_song_playcount)
    TextView  topSongPlaycount;
    @Bind(R.id.top_song_listeners)
    TextView  topSongListeners;

    public TopSongsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        Drawable progress = topSongRating.getProgressDrawable();
        DrawableCompat.setTint(progress, Color.rgb(255,50,120));
    }

    public void setDefaultImage(Context context){
        Picasso.with(context)
                .load(R.drawable.placeholder_image)
                .into(topSongImage);
    }

    public void setImage(Context context, String urlImage){
        Picasso.with(context)
                .load(urlImage)
                .placeholder(R.drawable.placeholder_image)
                .into(topSongImage);
    }

    public void setName(String name){
        this.topSongName.setText(name);
    }

    public void setTopSongRating(float rating){
        this.topSongRating.setRating(rating);
    }
    public void setPlayCount(int playCount){
        this.topSongPlaycount.setText(playCount + "");
    }

    public void setListeners(int listeners){
        if (listeners >= 100000){
            listeners = listeners/1000;
            this.topSongListeners.setText(listeners + "K");
        }
        this.topSongListeners.setText(listeners + "");
    }
}




































