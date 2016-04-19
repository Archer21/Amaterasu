package com.archer.amaterasu.ui.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.archer.amaterasu.R;
import com.archer.amaterasu.domain.Song;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
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

    public ImageView getimageContainer(){
        return topSongImage;
    }

    public void setImage(final Context context, int imageUrl, final ImageView imageContainer, final Song currentSong){
        Picasso.with(context)
                .load(imageUrl)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageContainer, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        //Try again online if cache failed
                        Picasso.with(context)
                                .load(currentSong.getSongImage())
                                .error(R.drawable.placeholder_image)
                                .into(imageContainer, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Log.v("Picasso","Could not fetch image");
                                    }
                                });
                    }
                });
    }
}
