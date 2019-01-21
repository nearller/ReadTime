package com.vrpip.app.readtime.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.vrpip.app.readtime.R;

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

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
        // 配置Toolbar
        initToolbar();
        //设置监听
        setListener();
    }

    protected void setUpToolbar(Toolbar toolbar){

    }

    protected ActionBar supportActionBar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(
                (v) -> finish()
        );
        return actionBar;
    }

    protected void initToolbar(){
        //更严谨是通过反射判断是否存在Toolbar
        mToolbar = findViewById(R.id.toolbar);
        if (mToolbar != null){
            supportActionBar(mToolbar);
            setUpToolbar(mToolbar);
        }
    }



    protected abstract int LayoutResID();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setListener();

}
