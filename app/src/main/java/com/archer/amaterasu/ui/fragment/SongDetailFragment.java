package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.utils.SetupTabsLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongDetailFragment extends SetupTabsLayout {

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
            new ArtistPersonalInformationFragment(),
            new ArtistSongsListFragment()
    };

    /**
     * Required Titles String Array for Tabs
     */
    private String[] tabsTitles = {
            "Information",
            "Songss List"
    };

    public SongDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(view);
        setupViewPager(viewPager, tabLayout, tabsFragments, tabsTitles);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_song_detail;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

}
