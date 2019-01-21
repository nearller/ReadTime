package com.vrpip.app.readtime;

import android.support.v7.widget.Toolbar;

import com.vrpip.app.readtime.base.BaseActivity;

import java.util.Objects;

public class MainActivity extends BaseActivity {


    @Override
    protected int LayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpToolbar(Toolbar toolbar) {
        super.setUpToolbar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("书库");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }
}
