package com.archer.amaterasu.ui.holder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.archer.amaterasu.R;
import com.archer.amaterasu.ui.adapter.TopSongsAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TopSongsViewHolder extends RecyclerView.ViewHolder{

    TopSongsAdapter.ItemClickListener clickListener;

    @Bind(R.id.top_song_image)
    SimpleDraweeView topSongImage;
    @Bind(R.id.top_song_name)
    TextView  topSongName;
    @Bind(R.id.top_song_rating)
    TextView topSongRating;
    @Bind(R.id.top_song_playcount)
    TextView  topSongPlaycount;
//    @Bind(R.id.top_song_listeners)
//    TextView  topSongListeners;

    public TopSongsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    clickListener.onItemClicked(getPosition());
                } else {
                    Log.e("Holder", "Not calling the method");
                }
            }
        });
//        Drawable progress = topSongRating.getProgressDrawable();
//        DrawableCompat.setTint(progress, Color.rgb(255,50,120));
    }

    public void setClickListener(TopSongsAdapter.ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
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

}




































