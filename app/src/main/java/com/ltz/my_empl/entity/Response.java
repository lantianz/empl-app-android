package com.ltz.my_empl.entity;

import java.io.Serializable;

public class Response implements Serializable {

    /**
     * code : 20000
     * message : 成功
     */

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
