package com.vrpip.app.readtime.view;

public interface BaseView {
    //Toast形式提示
    void showMsg(String msg);
    //加载提示框
    void showLoading();
    //隐藏加载提示框
    void hiddenLoading();
    //页面跳转
    void jumpActivity();
    //返回
    boolean back();
}
