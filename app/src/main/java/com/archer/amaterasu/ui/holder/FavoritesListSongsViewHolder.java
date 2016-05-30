package com.archer.amaterasu.ui.holder;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.archer.amaterasu.R;
import com.archer.amaterasu.domain.ListSong;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FavoritesListSongsViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.favorite_list_image)
    ImageView listImage;
    @Bind(R.id.favorite_list_name)
    TextView listName;
    @Bind(R.id.favorite_list_length)
    TextView songSize;

    public FavoritesListSongsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setListImage(Context context, String urlImage){
        Picasso.with(context)
                .load(urlImage)
                .placeholder(R.drawable.placeholder_image)
                .into(listImage);
    }


    public void setEmptyImage(Context context){
        Picasso.with(context)
                .load(R.drawable.empty)
                .into(listImage);
    }

    public void setListName(String name){
        this.listName.setText(name);
    }

    public void setListSize(int size) {
        this.songSize.setText("Songs: " + size);
    }
}


















