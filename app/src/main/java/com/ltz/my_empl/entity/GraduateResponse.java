package com.ltz.my_empl.entity;

public class GraduateResponse {

    /**
     * code : 20000
     * expire : null
     * data : {"studentId":"123456","gender":"男","major":"计算机科学与技术","grade":"2020","name":"测试名","department":"计算机科学与工程学院"}
     */

    private int code;
    private int expire;
    private GraduateEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public GraduateEntity getData() {
        return data;
    }

    public void setData(GraduateEntity data) {
        this.data = data;
    }
}
