package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    /**
     * Required Ids for Tabs
     */
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    /**
     * Required Fragments Array for Tabs
     */
    private Fragment[] tabsFragments = {
            new HotSongsFragment(),
            new TopSongsFragment(),
            new HypedArtistsFragment()
    };

    /**
     * Required Titles String Array for Tabs
     */
    private String[] tabsTitles = {
            "Hot",
            "Top songs"
    };


    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_home;
    }
}






























