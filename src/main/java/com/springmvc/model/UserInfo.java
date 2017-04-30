package com.springmvc.model;

import org.springframework.stereotype.Repository;

/**
 * Created by liaody on 2017/4/4.
 */
@Repository
public class UserInfo {
    // default constructor
    public UserInfo() {

    }

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

    public String getUserLoginFlag() {
        return userLoginFlag;
    }

    public void setUserLoginFlag(String userLoginFlag) {
        this.userLoginFlag = userLoginFlag;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private int userId;
    private String userName;
    private String userPassword;
    private String userLoginFlag;
    private String userEmail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) o;
        if (getUserId() != userInfo.getUserId()) return false;
        if (getUserName() != null ? !getUserName().equals(userInfo.getUserName()) : userInfo.getUserName() != null)
            return false;
        if (getUserPassword() != null ? !getUserPassword().equals(userInfo.getUserPassword()) : userInfo.getUserPassword() != null)
            return false;
        if (getUserLoginFlag() != null ? !getUserLoginFlag().equals(userInfo.getUserLoginFlag()) : userInfo.getUserLoginFlag() != null)
            return false;
        return getUserEmail() != null ? getUserEmail().equals(userInfo.getUserEmail()) : userInfo.getUserEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId();
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getUserPassword() != null ? getUserPassword().hashCode() : 0);
        result = 31 * result + (getUserLoginFlag() != null ? getUserLoginFlag().hashCode() : 0);
        result = 31 * result + (getUserEmail() != null ? getUserEmail().hashCode() : 0);
        return result;
    }
}
