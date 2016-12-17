package com.archer.amaterasu.ui.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {

    // VIEWS BINDED BY BUTTERKNIFE

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_search;
    }
}





























