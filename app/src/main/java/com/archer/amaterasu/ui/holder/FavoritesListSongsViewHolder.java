package com.archer.amaterasu.ui.holder;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.archer.amaterasu.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FavoritesListSongsViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.favorite_list_image)
    SimpleDraweeView listImage;
    @Bind(R.id.favorite_list_name)
    TextView listName;

    public FavoritesListSongsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setListImage(String urlImage){
        Uri uri = Uri.parse(urlImage);
        this.listImage.setImageURI(uri);
    }


    public void setEmptyImage(){
        listImage.setImageResource(R.drawable.empty);
    }

    public void setListName(String name){
        this.listName.setText(name);
    }
}


















