package com.ltz.my_empl.entity;

import java.io.Serializable;

public class NewsEntity implements Serializable {
    /**
     * id : 1
     * newsId : 1
     * title : 测试标题
     * author : 测试
     * sendTime : 2024-03-19 01:09
     * content : 121212
     */

    private int id;
    private String newsId;
    private String title;
    private String author;
    private String sendTime;
    private String frontImg;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getFrontImg() {
        return frontImg;
    }

    public void setFrontImg(String frontImg) {
        this.frontImg = frontImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}