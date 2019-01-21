package com.vrpip.app.readtime.model;

import com.vrpip.app.readtime.bean.User;

public interface LoginModel {

    int STATUS_FAIL = -1;// 验证失败
    int STATUS_SUCCESS = 0;// 成功
    int STATUS_NORMAL = 1;// 正常状态

    void login(User user,LoginCallBack loginCallBack);

    interface LoginCallBack {
        void onStatus();
    }
}
