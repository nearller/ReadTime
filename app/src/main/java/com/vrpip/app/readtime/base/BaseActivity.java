package com.vrpip.app.readtime.base;


import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutResID());
        initFindViewByID();
        initView();
        initData();
        setListener();
    }

    protected abstract void initFindViewByID();

    protected abstract int LayoutResID();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setListener();

}
