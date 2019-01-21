package com.vrpip.app.readtime.base;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutResID());
        // 锁定竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //初始化控件
        initView();
        //设置数据
        initData();
        //设置监听
        setListener();
    }
    protected abstract int LayoutResID();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setListener();

}
