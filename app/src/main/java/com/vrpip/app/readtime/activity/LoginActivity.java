package com.vrpip.app.readtime.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vrpip.app.readtime.MainActivity;
import com.vrpip.app.readtime.R;
import com.vrpip.app.readtime.base.BaseActivity;
import com.vrpip.app.readtime.bean.User;
import com.vrpip.app.readtime.presenter.LoginPresenter;
import com.vrpip.app.readtime.view.LoginView;

@SuppressLint("Registered")
public class LoginActivity extends BaseActivity implements LoginView {

    private EditText editText_username;
    private EditText editText_password;
    private Button button_login;
    private long lastTime;

    private LoginPresenter loginPresenter;

    @Override
    protected int LayoutResID() {
        return R.layout.login_layout;
    }

    @Override
    protected void initView() {
        editText_username = findViewById(R.id.loginLayout_username);
        editText_password = findViewById(R.id.loginLayout_password);
        button_login = findViewById(R.id.loginLayout_btn);
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(editText_username.getText().toString(),editText_password.getText().toString());
                loginPresenter.login(user);
            }
        });
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void jumpActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public boolean back() {
        long currTime=System.currentTimeMillis();
        if(currTime-lastTime>1000){
            showMsg("再按一次退出");
            lastTime=currTime;
        }else{
            finish();
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            return back();
        }
        return super.onKeyDown(keyCode, event);
    }
}
