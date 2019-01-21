package com.vrpip.app.readtime.presenter;

import com.vrpip.app.readtime.bean.User;
import com.vrpip.app.readtime.model.impl.LoginModelImpl;
import com.vrpip.app.readtime.view.LoginView;

public class LoginPresenter {
    private LoginModelImpl loginModelImpl;
    private LoginView loginView;

    public LoginPresenter (LoginView loginView) {
        loginModelImpl = new LoginModelImpl();
        this.loginView = loginView;
    }

    /**
     * 调用model进行数据处理，根据回调接口来操作ILoginView进行对应的activity界面更新
     */
    public void login(User user) {
        loginModelImpl.login(user, new LoginModelImpl.LoginCallBack() {

            public void onStatus() {
                switch (loginModelImpl.status) {
                    case LoginModelImpl.STATUS_SUCCESS:
                        loginView.jumpActivity();
                        loginView.showMsg(loginModelImpl.msg);
                        break;
                    case LoginModelImpl.STATUS_FAIL:
                        loginView.showMsg(loginModelImpl.msg);
                        break;
                    default:
                        break;
                }
                loginModelImpl.status=loginModelImpl.STATUS_NORMAL;
            }
        });
    }

}
