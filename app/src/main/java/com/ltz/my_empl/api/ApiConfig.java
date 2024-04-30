package com.ltz.my_empl.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.ltz.my_empl.MainActivity;

public class ApiConfig {

    public static String IP = "192.168.1.3";
    public static String BASE_URL(String val){
        ApiConfig config = new ApiConfig();
        if (config.getIP().isEmpty()){
            config.setIP(IP);
        }
        if (val.equals("0")){
            return config.getIP();
        } else if (val.equals("1")) {
            return "http://"+ config.getIP() +":8888/api";
        } else {
            config.setIP(val);
        }
        return config.getIP();
    }
    public static final int PAGE_SIZE = 10;
    public static final String LOGIN = "/app/login";
    public static final String STAND_INFO = "/standInfo/getStandInfo";
    public static final String EMPL_SUBMIT = "/app/add";
    public static final String EMPL_RESUBMIT = "/app/reAdd";
    public static final String EMPL_CHECK = "/app/getByStudentId";
    public static final String NEWS_LIST_PAGE = "/app/getEmplNewsByPage";
    public static final String NEWS_LIST_SEARCH = "/app/getEmplNewsBySearch";
    public static final String FILE_DOWNLOAD = "/files/download/";

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
