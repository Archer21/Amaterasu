package com.archer.amaterasu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.archer.amaterasu.R;
import com.archer.amaterasu.utils.SetupTabsLayout;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends SetupTabsLayout {

    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;

    private Fragment[] tabsFragments = {
            new TopSongsFragment(),
            new TopArtistFragment()
    };

    private String[] tabsTitles = {
            "Top Songs",
            "Top Artists"
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(view);
        setupViewPager(viewPager, tabLayout, tabsFragments, tabsTitles);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main;
    }
}
