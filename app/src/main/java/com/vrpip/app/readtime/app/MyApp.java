package com.vrpip.app.readtime.app;


import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    //记录当前栈里所有activity
    private List<Activity> activities = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;

//        //异常友好管理初始化
//        Recovery.getMyApp()
//                .debug(true)
//                .recoverInBackground(false)
//                .recoverStack(true)
//                .mainPage(WelcomeActivity.class)
////                .skip(H5PayActivity.class)  如果应用集成支付宝支付 记得加上这句代码  没时间解释了  快上车  老司机发车了
//                .init(this);
    }
    /**
     * 应用实例
     **/
    private static MyApp myApp;

    /**
     * 获得实例
     *
     * @return myAPP
     */
    public static MyApp getMyApp() {
        return myApp;
    }

    /**
     * 新建了一个activity
     *
     * @param activity 本身
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity 本身
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            this.activities.remove(activity);
            activity.finish();
        }
    }
    /**
     * 应用退出，结束所有的activity
     */
    public void exit() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }
}
