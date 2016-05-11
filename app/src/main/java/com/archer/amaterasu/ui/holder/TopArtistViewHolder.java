package com.archer.amaterasu.ui.holder;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.archer.amaterasu.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopArtistViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.top_artist_image)
    SimpleDraweeView artistImage;
    @Bind(R.id.top_artist_name)
    TextView artistText;

    public TopArtistViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public void setArtistImage(String urlImage){
        Uri uri = Uri.parse(urlImage);
        artistImage.setImageURI(uri);
    }
}


















