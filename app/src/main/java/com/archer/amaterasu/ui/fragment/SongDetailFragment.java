package com.archer.amaterasu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongDetailFragment extends BaseFragment {

    private static final String IMAGE_URL = "IMAGE";

    @BindView(R.id.song_image)
    ImageView image;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String urlImage = getActivity().getIntent().getStringExtra(IMAGE_URL);

        if (urlImage != null) {
            setImage(urlImage);
        }
    }

    /**
     * Methods for set the data
     */

    private void setImage (String url) {
        Picasso.with(CONTEXT).load(url).into(image);
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_song_detail;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }
}











































