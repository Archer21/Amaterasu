package com.archer.amaterasu.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseActivity;
import com.archer.amaterasu.ui.fragment.SongDetailFragment;
import com.archer.amaterasu.utils.Helpers;

import butterknife.BindView;

public class SongDetailActivity extends BaseActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Helpers.setupFragment(fragmentManager, new SongDetailFragment(), R.id.container_song_detail);
        }
    }

    @Override
    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_song_detail;
    }
}








































