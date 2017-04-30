package com.springmvc.service;

import com.springmvc.model.RegisterUser;
import org.springframework.stereotype.Service;

/**
 * Created by liaody on 2017/4/9.
 */
@Service
public interface RegisterService extends SqlMapper {
    public void registerUser(RegisterUser user);
    public RegisterUser getUser(RegisterUser user);

}
