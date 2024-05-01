package com.ltz.my_empl.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.ltz.my_empl.MainActivity;

public class IPUtils {
    Context context = MainActivity.getAppContext();
    public String getIP() {
        String key = "ip";
        SharedPreferences sp = context.getSharedPreferences("sp_config", Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }

    public void setIP(String value) {
        String key = "ip";
        SharedPreferences sp = context.getSharedPreferences("sp_config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
