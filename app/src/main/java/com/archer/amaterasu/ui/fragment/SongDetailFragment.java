package com.archer.amaterasu.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.domain.Song;
import com.facebook.drawee.view.SimpleDraweeView;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongDetailFragment extends BaseFragment {

    @Bind(R.id.song_background)
    SimpleDraweeView songBackground;
    @Bind(R.id.song_title)
    TextView songTitle;
    @Bind(R.id.song_image)
    SimpleDraweeView songImage;
    @Bind(R.id.artist_name)
    TextView artistName;

    Realm realm;
    Song  currentSong;

    public SongDetailFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_song_detail;
    }

    @Override
    public void onResume() {
        super.onResume();
        configSong();
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(getActivity(), view);
    }

    public void configSong(){
        currentSong = Parcels.unwrap(getActivity().getIntent().getParcelableExtra("SONG"));
        setSongBackground(currentSong.getSongImageMedium());
        setSongImage(currentSong.getSongImageSmall());
        setSongTitle(currentSong.getSongTitle());
        setSongArtistName(currentSong.getSongArtist());
    }

    public void setSongBackground(String urlImage){
        Uri uri = Uri.parse(urlImage);
        songBackground.setImageURI(uri);
    }

    public void setSongImage(String urlImage){
        Uri uri = Uri.parse(urlImage);
        songImage.setImageURI(uri);
    }

    public void setSongTitle(String title){
        songTitle.setText(title);
    }

    public void setSongArtistName(String name){
        artistName.setText(name);
    }
}














