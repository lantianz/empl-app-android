package com.ltz.my_empl.util;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.Window;

public class StatusBar {
    // 设置状态栏为透明
    public static void setStatusBarTransparent(Activity activity) {
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }

    public static void setStatusBarLightMode(Activity activity, boolean isLightMode) {
        Window window = activity.getWindow();
        int option = window.getDecorView().getSystemUiVisibility();
        if (isLightMode) {
            option |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        } else {
            option &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }
        window.getDecorView().setSystemUiVisibility(option);
    }
}
