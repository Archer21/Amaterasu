package com.archer.amaterasu.ui.holder;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.archer.amaterasu.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FavoritesListArtistsViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.artist_image)
    SimpleDraweeView artistImage;

    public FavoritesListArtistsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setArtistImage(String artistImage){
        Uri uri = Uri.parse(artistImage);
        this.artistImage.setImageURI(uri);
    }

//    public void setArtistImage(Context context, String artistImage){
//        Picasso.with(context)
//                .load(artistImage)
//                .placeholder(R.drawable.placeholder_image)
//                .into(artistImage);
//    }
}


























