package com.springmvc.controller;

import com.springmvc.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>HTTP请求数据绑定</p>
 * <p>通过注解绑定：
 *
 * @RequestParam->绑定请求参数
 * @RequestHeader->绑定请求头参数
 * @CokkieValue->绑定Cookie值
 * @PathVariable->绑定URL中的变量 </p>
 * <p>
 * <p>
 * Created by Administrator on 2017/4/30.
 */
@Controller("dataBindController")
public class DataBindController {

    /**
     * default constructor
     */
    public DataBindController() {

    }

    /**
     * <p>@RequestParam->绑定请求参数.</p>
     * <p>RequestMapping限定中中不需要写明参数名，当参数中含有制定的参数名时会实现自动绑定</p>
     * <p>需要注意的是@RequestParam有三个参数，分别是默认的value、required（默认为true）、
     * defaultValue默认值（不推荐使用）。
     * 当请求中不存在对应的参数时，会抛出异常。如果参数不是必须的可以将required设置为false.（例子中的userEmail）
     * </p>
     *
     * @return
     */
    @RequestMapping(value = "/requestParamBind")
    public ModelAndView requestParamBind(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, @RequestParam(value = "userEmail", required = false) String userEmail) {
        ModelAndView mv = new ModelAndView();
        System.out.println("使用@RequestParam绑定请求参数中的userName和userPassword");
        System.out.println("userName：" + userName);
        System.out.println("userPassword：" + userPassword);
        mv.setViewName("/success");
        mv.addObject("message", "userName/userPassword" + userName + "/" + userPassword);
        return mv;
    }

    /**
     * <p>使用命令/表单对象绑定</p>
     * <p>
     *   所谓命令/表单对象并不需要实现任何借口，仅是一个拥有若歌属性的POJO，SpringMvc按照：“HTTP请求参数名=命令/表单对象的属性名”的
     *   的规则，自动绑定请求请求数据，支持级联属性名，自动进行基本数据类型的转换。
     * </p>
     * <p>需要注意的是@RequestParam有三个参数，分别是默认的value、required（默认为true）、
     * defaultValue默认值（不推荐使用）。
     * 当请求中不存在对应的参数时，会抛出异常。如果参数不是必须的可以将required设置为false.（例子中的userEmail）
     * </p>
     * <p>
     * userName=YY&userPassword=ZZ&userLoginFlag=1&userEmail=22@.qqcom->自动映射到UserInfo相关字段。     *
     * </p>
     *
     * @return
     */
    @RequestMapping(value = "/requestParamBindPojo")
    public ModelAndView requestParamBindPojo(UserInfo userInfo) {
        ModelAndView mv = new ModelAndView();
        System.out.println(userInfo.toString());
        mv.setViewName("/success");
        mv.addObject("message", "命令/表单对象绑定" + userInfo.toString());
        return mv;
    }

}
