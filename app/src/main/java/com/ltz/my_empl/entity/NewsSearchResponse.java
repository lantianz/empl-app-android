package com.ltz.my_empl.entity;

import java.io.Serializable;
import java.util.List;

public class NewsSearchResponse implements Serializable {

    /**
     * code : null
     * message : 全部就业资讯
     * total : 2
     * data : [{"id":1,"newsId":"1686687052","title":"测试标题","author":"测试","sendTime":"2023-06-14 04:10","frontImg":null,"content":"121212"},{"id":52,"newsId":"1681275448","title":"测试狗头","author":"测试狗头","sendTime":"2023-04-12 12:57","frontImg":null,"content":"<p>测试狗头<br/><br/><img src=\"https://ts1.cn.mm.bing.net/th?id=OIP-C.BLY1fvoPyIATuPsRhT-RswHaHa&amp;w=189&amp;h=185&amp;c=8&amp;rs=1&amp;qlt=90&amp;o=6&amp;dpr=1.3&amp;pid=3.1&amp;rm=2\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/><\/p>"}]
     * data1 : null
     */

    private int code;
    private String message;
    private int total;
    private List<NewsEntity> data;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<NewsEntity> getData() {
        return data;
    }

    public void setData(List<NewsEntity> data) {
        this.data = data;
    }
}
