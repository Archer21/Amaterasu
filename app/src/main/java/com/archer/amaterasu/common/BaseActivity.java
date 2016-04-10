package com.archer.amaterasu.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.archer.amaterasu.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        injectViews();
    }

    public void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }

    protected Toolbar getToolbar(){
        return mToolbar;
    }

    protected abstract int getLayout();

    private void injectViews() {
        ButterKnife.bind(this);
    }
}
