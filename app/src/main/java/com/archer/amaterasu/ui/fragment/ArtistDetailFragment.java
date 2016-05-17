package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.utils.SetupTabsLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistDetailFragment extends SetupTabsLayout {

    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.artist_name)
    TextView artistName;

    Fragment[] tabsFragments = {
            new ArtistPersonalInformationFragment(),
            new ArtistSongsListFragment()
    };

    String[] tabsTitles = {
            "Personal Information",
            "List Songs"
    };


    public ArtistDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(view);
        Bundle bundle = getActivity().getIntent().getExtras();
        String name = bundle.getString("NAME");
        artistName.setText(name);
        setupViewPager(viewPager, tabLayout, tabsFragments, tabsTitles);
        tabLayout.setTabTextColors(R.color.primaryText, R.color.primaryText);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_artist_detail;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

}

















