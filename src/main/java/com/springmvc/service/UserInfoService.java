package com.springmvc.service;

import com.springmvc.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoService extends SqlMapper{

    public void addUser(UserInfo user);
    public void deleteUser(int id);
    public UserInfo getUser(UserInfo user);
    public void updateUser(UserInfo user);
}
