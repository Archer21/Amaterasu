package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.utils.SetupTabsLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends SetupTabsLayout {

    /**
     * Required Ids for Tabs
     */
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;

    /**
     * Required Fragments Array for Tabs
     */
    private Fragment[] tabsFragments = {
            new FavoritesListSongsFragment(),
            new FavoritesListArtistsFragment()
    };

    /**
     * Required Titles String Array for Tabs
     */
    private String[] tabsTitles = {
            "My song list",
            "My favorite artists"
    };

    public FavoritesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(CONTEXT, view);
        setupViewPager(viewPager, tabLayout, tabsFragments, tabsTitles);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_favorites;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}












