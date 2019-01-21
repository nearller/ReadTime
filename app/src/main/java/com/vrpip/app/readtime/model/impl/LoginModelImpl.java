package com.vrpip.app.readtime.model.impl;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.vrpip.app.readtime.bean.User;
import com.vrpip.app.readtime.model.LoginModel;

public class LoginModelImpl implements LoginModel {
    public int status;    //记录登陆状态
    public String msg;

    @SuppressLint("StaticFieldLeak")
    @Override
    public void login(final User user, final LoginCallBack loginCallBack) {
        final String username = user.getUsername();
        final String password = user.getPassword();
        new AsyncTask<Void, Void, LoginCallBack>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected LoginCallBack doInBackground(Void... voids) {
                if (username.equals("123") && password.equals("123")) {
                    msg = "登录成功";
                    status = LoginModel.STATUS_SUCCESS;
                }else {
                    msg = "用户名或密码错误";
                    status = LoginModel.STATUS_FAIL;
                }
                return loginCallBack;
            }
            @Override
            protected void onPostExecute(LoginCallBack result) {
                loginCallBack.onStatus();    //登陆成功后进行接口回调，告诉presenter对view操作进行界面操作
                super.onPostExecute(result);
            }
        }.execute();
    }
}
