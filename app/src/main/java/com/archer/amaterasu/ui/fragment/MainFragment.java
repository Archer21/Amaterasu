package com.archer.amaterasu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.utils.PagerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        setupViewPager();
    }

    private void setupViewPager() {
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), buildFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Top Songs");
        tabLayout.getTabAt(1).setText("Top Artists");

    }

    private ArrayList<Fragment> buildFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new TopSongsFragment());
        fragments.add(new TopArtistFragment());

        return fragments;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main;
    }
}
