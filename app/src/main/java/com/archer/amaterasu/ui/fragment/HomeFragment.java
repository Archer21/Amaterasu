package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.utils.SetupTabLayout;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends SetupTabLayout {
    // REQUIRED VIEWS FOR TABS
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;


    // REQUIRED FRAGMENTS FOR TABS
    private Fragment[] tabsFragments = {
            new HotSongsFragment(),
            new TopSongsFragment(),
            new HypedArtistsFragment()
    };

    // REQUIRED TAB TITLES
    private String[] tabsTitles = {
            "Hot",
            "Top songs",
            "Hyped artists"
    };

    // FRAGMENT LIFECYCLE OVERRIDED METHODS
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupTabs(viewPager, tabLayout, tabsFragments, tabsTitles);
    }



    // OVERRIDED METHODS FROM BASEFRAGMENT
    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_home;
    }
}






























