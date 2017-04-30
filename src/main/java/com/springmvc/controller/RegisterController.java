package com.springmvc.controller;

import com.springmvc.model.RegisterUser;
import com.springmvc.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

/**
 * Created by liaody on 2017/4/9.
 */
@Controller
@RequestMapping("liaody/")
public class RegisterController {

    @Autowired
    private RegisterUser registerUser;
    @Autowired
    private RegisterService registerService ;
//    private
    /**
     * default constructor
     */
    public RegisterController() {

    }

    /**
     * 提供用户注册功能
     *
     * @return
     */
    @RequestMapping(value = "/register", params = {"userName", "userPassword", "userEmail"})
    public ModelAndView register(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, @RequestParam("userEmail") String userEmail) throws UnsupportedEncodingException {
        ModelAndView mv = new ModelAndView();
        if(StringUtils.isEmpty(userName)|| StringUtils.isEmpty(userPassword)||StringUtils.isEmpty(userEmail)){
            throw new IllegalArgumentException("用户名、用户密码、邮箱地址不能为空！");
        }
        // 转码:utf-8
        String pUserName = new String (userName.getBytes(),"utf-8" );
        String pUserPassword = new String (userPassword.getBytes(),"utf-8" );
        String pUserEmail = new String (userEmail.getBytes(),"utf-8" );
        System.out.println("注册用户名："+userName+" 密码："+userPassword+" 邮箱："+userEmail);

        // 注册用DTO作成
        registerUser.setUserName(pUserName);
        registerUser.setUserPassword(pUserPassword);
        registerUser.setUserEmail(pUserEmail);

        // 调用业务逻辑组件：注册用service注册用户
        registerService.registerUser(registerUser);

        // 验证：调用
    //  Thread.sleep(3000);
        RegisterUser validaUser = registerService.getUser(registerUser);

        if(StringUtils.isEmpty(validaUser.getUserName()) ){
            mv.addObject("massage","注册失败！");
            mv.setViewName("/register");
        }else{
            mv.addObject("massage","恭喜您，"+validaUser.getUserName()+",注册成功！");
            mv.setViewName("/success");
        }
        return mv;
    }


}
