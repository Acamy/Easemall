package com.hebaohua.netease.entity;

public class User {
    private Integer userId;

    private String userName;

    private String userPwd;

    private int userType;

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}