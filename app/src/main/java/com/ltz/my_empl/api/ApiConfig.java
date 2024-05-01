package com.ltz.my_empl.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.ltz.my_empl.MainActivity;
import com.ltz.my_empl.util.IPUtils;

public class ApiConfig {
    public static String IP = "10.0.0.168";
    IPUtils ipUtils = new IPUtils();
    public static String BASE_URL(String val){
        ApiConfig config = new ApiConfig();
        if (config.ipUtils.getIP().isEmpty()){
            config.ipUtils.setIP(IP);
        }
        if (val.equals("0")){
            return config.ipUtils.getIP();
        } else if (val.equals("1")) {
            return "http://"+ config.ipUtils.getIP() +":8888/api";
        } else {
            config.ipUtils.setIP(val);
        }
        return config.ipUtils.getIP();
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

}
