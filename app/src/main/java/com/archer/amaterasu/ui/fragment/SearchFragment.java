package com.archer.amaterasu.ui.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {
    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }
}





























