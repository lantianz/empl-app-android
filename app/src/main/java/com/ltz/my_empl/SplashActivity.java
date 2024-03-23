package com.ltz.my_empl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ltz.my_empl.util.StatusBar;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private static final int sleepTime = 1000;
    private boolean isLightMode = true;

    @Override
    protected void onCreate(Bundle arg0) {
        final View view = View.inflate(this, R.layout.activity_splash, null);
        setContentView(view);
        super.onCreate(arg0);

        StatusBar.setStatusBarTransparent(this);
        StatusBar.setStatusBarLightMode(this, isLightMode);

    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                long costTime = System.currentTimeMillis() - start;
                //等待sleeptime时长
                if (sleepTime - costTime > 0) {
                    try {
                        Thread.sleep(sleepTime - costTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //进入主页面
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }).start();
    }
}
