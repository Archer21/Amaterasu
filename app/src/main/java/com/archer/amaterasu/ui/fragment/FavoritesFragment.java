package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends BaseFragment {

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        addFragments(fragmentTransaction);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_favorites;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_favorites_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.add_list:
                Toast.makeText(CONTEXT, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_list:
                Toast.makeText(CONTEXT, "Deleted:" + item.getTitle(), Toast.LENGTH_SHORT).show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addFragments(FragmentTransaction fragmentTransaction){
        fragmentTransaction.add(R.id.favorites_songs_list , fragments[0]);
        fragmentTransaction.add(R.id.favorites_artists_list, fragments[1]);
        fragmentTransaction.commit();
    }

}












