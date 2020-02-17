package com.example.plugintest;

import android.app.Application;
import android.content.Context;

/**
 * Created by yds
 * on 2019/8/13.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        try {
            HookHelper.hookInstrumentation(base,"com.example.plugintest.SubActivity");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
