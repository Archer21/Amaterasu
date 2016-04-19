package com.archer.amaterasu.utils;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.archer.amaterasu.common.BaseFragment;
import java.util.ArrayList;

public abstract class SetupTabsLayout extends BaseFragment {
    public void setupViewPager(ViewPager viewPager, TabLayout tabLayout, Fragment[] fragments, String[] tabsTitles) {
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

















