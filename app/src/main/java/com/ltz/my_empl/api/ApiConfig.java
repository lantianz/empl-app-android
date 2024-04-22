package com.ltz.my_empl.api;

public class ApiConfig {
    public static final int PAGE_SIZE = 10;
    public static final String BASE_URL = "http://192.168.124.3:8888/api"; //10.0.0.168
    public static final String LOGIN = "/app/login";
    public static final String STAND_INFO = "/standInfo/getStandInfo";
    public static final String EMPL_SUBMIT = "/app/add";
    public static final String EMPL_RESUBMIT = "/app/reAdd";
    public static final String EMPL_CHECK = "/app/getByStudentId";
    public static final String NEWS_LIST_PAGE = "/app/getEmplNewsByPage";
    public static final String NEWS_LIST_SEARCH = "/app/getEmplNewsBySearch";
    public static final String FILE_DOWNLOAD = "/files/download/";
}
