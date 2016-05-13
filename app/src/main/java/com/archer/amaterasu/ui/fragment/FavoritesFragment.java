package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

    public FavoritesFragment() {
        // Required empty public constructor
    }
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment[] fragments = {
            new FavoritesListSongsFragment(),
            new FavoritesListArtistsFragment()
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favorites, container, false);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        addFragments(fragmentTransaction);
        return root;
    }

    public void addFragments(FragmentTransaction fragmentTransaction){
        fragmentTransaction.add(R.id.favorites_songs_list , fragments[0]);
        fragmentTransaction.add(R.id.favorites_artists_list, fragments[1]);
        fragmentTransaction.commit();
    }

}












