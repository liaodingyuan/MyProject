package com.springmvc.model;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/9.
 */
@Repository
public class RegisterUser {
    /**
     * default constructor
     */
    public RegisterUser(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterUser)) return false;

        RegisterUser that = (RegisterUser) o;

        if (getUserId() != that.getUserId()) return false;
        if (!getUserName().equals(that.getUserName())) return false;
        if (!getUserPassword().equals(that.getUserPassword())) return false;
        return getUserEmail().equals(that.getUserEmail());
    }

    @Override
    public int hashCode() {
        int result = getUserId();
        result = 31 * result + getUserName().hashCode();
        result = 31 * result + getUserPassword().hashCode();
        result = 31 * result + getUserEmail().hashCode();
        return result;
    }

    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
