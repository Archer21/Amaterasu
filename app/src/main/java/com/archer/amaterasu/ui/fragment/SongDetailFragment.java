package com.archer.amaterasu.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.domain.ListSong;
import com.archer.amaterasu.domain.Song;
import com.facebook.imagepipeline.request.Postprocessor;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import jp.wasabeef.picasso.transformations.BlurTransformation;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongDetailFragment extends BaseFragment {

    private static final String LOG_TAG = SongDetailFragment.class.getSimpleName();
    @Bind(R.id.song_background)
    ImageView songBackground;
    @Bind(R.id.song_title)
    TextView songTitle;
    @Bind(R.id.song_image)
    ImageView songImage;
    @Bind(R.id.artist_name)
    TextView artistName;

    Song  song;

//    Obtendremos los ids de las listas guardadas en SharedPreferences
//    dependiendo el caso armaremos un Array con ellas


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
        song = Parcels.unwrap(getActivity().getIntent().getParcelableExtra("SONG"));
        setSongBackground(song.getSongImageMedium());
        setSongImage(song.getSongImageSmall());
        setSongTitle(song.getSongTitle());
        setSongArtistName(song.getSongArtist());
    }

    public void setSongBackground(String urlImage){
        Picasso.with(CONTEXT)
                .load(urlImage)
                .placeholder(R.drawable.placeholder_image)
                .transform(new BlurTransformation(CONTEXT, 15))
                .into(songBackground);
    }

    public void setSongImage(String urlImage){
        Picasso.with(CONTEXT)
                .load(urlImage)
                .placeholder(R.drawable.placeholder_image)
                .into(songImage);
    }

    public void setSongTitle(String title){
        songTitle.setText(title);
    }

    public void setSongArtistName(String name){
        artistName.setText(name);
    }

    @OnClick(R.id.button_favorite)
    public void addToFavorites(){
        new MaterialDialog.Builder(CONTEXT)
                .title("Add song to:")
                .items(IDsListSongsArray)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, final CharSequence text) {
                        getRealm().executeTransaction(new Realm.Transaction(){
                            @Override
                            public void execute(Realm realm) {
                                ListSong list = getRealm().where(ListSong.class).equalTo("name", text.toString()).findFirst();
                                list.getSongs().add(song);
                                getRealm().copyToRealmOrUpdate(list);
                            }
                        });
                        return true;
                    }
                })
                .positiveText("Agregar")
                .show();
    }
}














