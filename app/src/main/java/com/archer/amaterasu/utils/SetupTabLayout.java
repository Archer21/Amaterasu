package com.archer.amaterasu.utils;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.*;

import com.archer.amaterasu.common.BaseFragment;

import java.util.ArrayList;

/**
 * Created by alanaliaga on 17/12/16.
 */

public abstract class SetupTabLayout extends BaseFragment {

    public void setupViewPage (ViewPager viewPager, TabLayout tabLayout, Fragment[] fragments, String[] tabsTitles) {
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), buildFragments(fragments)));
        tabLayout.setupWithViewPager(viewPager);
        setTabsName(tabLayout, tabsTitles);
    }

    public ArrayList<Fragment> buildFragments(Fragment[] fragmentsArray) {

        ArrayList<Fragment> fragments = new ArrayList<>();

        for (Fragment fragment : fragmentsArray) {
            fragments.add(fragment);
        }

        return fragments;
    }

    public void setTabsName(TabLayout tabLayout, String[] tabsTitles){
        int size = tabsTitles.length;
        for (int i = 0; i < size; i++) {
            tabLayout.getTabAt(i).setText(tabsTitles[i]);
        }
    }

}































