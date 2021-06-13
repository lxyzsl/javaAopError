package com.lxy.springMVC.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * 用户
 */
public class User {
    //ID
    private int id;
    //手机号
    private String mobile;
    //密码
    @JsonIgnore
    private String password;
    //推荐人
    private String referer;
    //注册时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date date;

    public User() {
    }

    public User(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
        this.date = new Date();
    }

    public User(int id, String mobile, Date date) {
        this.id = id;
        this.mobile = mobile;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", referer='" + referer + '\'' +
                ", date=" + date +
                '}';
    }


}
