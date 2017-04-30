package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>前期准备：了解Http请求报文结构与内容。</p>
 * <p>测试Http请求地址映射。</p>
 * author：liaody
 */
@Controller
public class ViewController {

    /**
     * <p>简单的测试Mvc框架是否搭建完成</p>
     *
     * @return 视图名称
     */
    @RequestMapping("/view")
    public String view() {
        System.out.println("你已通过springMVC进入controller方法。。。。");
        return "index";
    }

    /**
     * <p>通过URL限定:*。</p>
     * <p>示例：
     * value="/user/*\/createUser，匹配user/createUser、user/aaa/createUser、user/bb/createUser。*代表零个或多个字符。
     * </p>
     * <p>
     * 访问的url：http://localhost:8080/user/createUser、url：http://localhost:8080/user/aaa/createUser、url：http://localhost:8080/user/bb/createUser
     * </p>
     *
     * @return
     */
    @RequestMapping(value = "/user/*/createUser")
    public ModelAndView paramUrl() {
        ModelAndView mv = new ModelAndView();
        System.out.println("调用paramUrl方法");
        mv.addObject("message", "user/*/createUser匹配：url：http://localhost:8080/user/createUser");
        mv.addObject("message2", "user/*/createUser匹配：url：http://localhost:8080/user/aaa/createUser");
        mv.addObject("message3", "user/*/createUser匹配：url：http://localhost:8080/user/bb/createUser");
        mv.setViewName("/success");
        return mv;
    }

    /**
     * <p>通过URL限定:**。</p>
     * <p>示例：
     * value="/user/**\/createUser，匹配user/createUser、user/aa/bb/createUser、user/aa/bb/cc/createUser。**代表可以有多个路径。
     * </p>
     * <p>
     * 访问的url：http://localhost:8080/user/createUser、http://localhost:8080/user/aa/bb/createUser、http://localhost:8080/user/aa/bb/cc/createUser
     * </p>
     *
     * @return
     */
    @RequestMapping(value = "user/**/createUser")
    public ModelAndView paramUrl2() {
        ModelAndView mv = new ModelAndView();
        System.out.println("调用paramUrl2方法");
        mv.addObject("message", "user/**/createUser匹配：url：http://localhost:8080/user/createUser");
        mv.addObject("message2", "user/**/createUser匹配：url：http://localhost:8080/user/aa/bb/createUser");
        mv.addObject("message3", "user/**/createUser匹配：url：http://localhost:8080/user/aa/bb/cc/createUser");
        mv.setViewName("/success");
        return mv;
    }

    /**
     * <p>通过URL限定:{}占位符。</p>
     * <p>示例：
     * value="/user/**\/{userId}，匹配/user/aa/123、/user/aa/bb/abc、/user/aa/bb/cc/ddd
     * </p>
     * <p>
     * 访问的url：url：http://localhost:8080/user/aa/123、http://localhost:8080/user/aa/bb/abc、http://localhost:8080/user/aa/bb/cc/ddd
     * </p>
     *
     * @return
     */
    @RequestMapping(value = "user/**/{userId}")
    public ModelAndView paramUrl3(@PathVariable("userId") String userId) {
        ModelAndView mv = new ModelAndView();
        System.out.println("调用paramUrl3方法");
        System.out.println("使用@PathVariable注解绑定参数userId：" + userId);
        mv.addObject("message", "user/**/{userId}匹配：url：http://localhost:8080/user/aa/123");
        mv.addObject("message2", "user/**/{userId}匹配：url：http://localhost:8080/user/aa/bb/abc");
        mv.addObject("message3", "user/**/{userId}匹配：url：http://localhost:8080/user/aa/bb/cc/ddd");
        mv.setViewName("/success");
        return mv;
    }

    /**
     * <p>通过URL限定:?。</p>
     * <p>示例：
     * value="/user/createUser??，匹配user/createUseraa、user/createUserbb。?代表0个或一个字符。
     * </p>
     * <p>
     * 访问的url：http://localhost:8080/user/createUseraa、http://localhost:8080/user/createUserbb
     * </p>
     *
     * @return
     */
    @RequestMapping(value = "/user/createUser??")
    public ModelAndView paramUrl4() {
        ModelAndView mv = new ModelAndView();
        System.out.println("调用paramUrl4方法");
        mv.addObject("message", "user/createUser??匹配：url：http://localhost:8080/user/createUseraa");
        mv.addObject("message2", "user/createUser??匹配：url：http://localhost:8080/user/createUserbb");
        mv.setViewName("/success");
        return mv;
    }

    /**
     * <p>通过URL限定:{XXX}绑定XXX参数值。</p>
     * <p>示例：
     * value="/owners/{ownerId}，匹配owners/123、owners/abc
     * </p>
     * <p>
     * 访问的url：http://localhost:8080/owners/123、http://localhost:8080/owners/abc
     * </p>
     * <p>
     * 如果@PathVariable不指定参数名，只有在编译的时候打开窗debug开关才有效，建议不要做么做。
     * <p>
     * </p>
     *
     * @return
     */
    @RequestMapping(value = "/owners/{ownerId}")
    public ModelAndView paramUrl5(@PathVariable("ownerId") String ownerId) {
        ModelAndView mv = new ModelAndView();
        System.out.println("调用paramUrl5方法");
        mv.addObject("message", "/owners/{ownerId}匹配：url：http://localhost:8080/owners/123");
        mv.addObject("message2", "user/createUser??匹配：url：http://localhost:8080/owners/abc");
        mv.addObject("message3", "被绑定的参数" + ownerId);
        mv.setViewName("/success");
        return mv;
    }


    /**
     * <p>通过请求方法限定：post</p>
     *
     * @return
     */
    @RequestMapping(value = "/method/post", method = RequestMethod.POST)
    public ModelAndView methodPost() {
        ModelAndView mv = new ModelAndView();
        System.out.println("调用的是post方法");
        mv.setViewName("/success");
        mv.addObject("message", "成功调用的是post方法");
        return mv;
    }

    /**
     * <p>通过请求方法限定:get</p>
     * <p>value值故意设置与上面的一样value="/method/post"</p>
     *
     * @return
     */
    @RequestMapping(value = "/method/post", method = RequestMethod.GET)
    public ModelAndView methodGet() {
        ModelAndView mv = new ModelAndView();
        System.out.println("调用的是Get方法");
        mv.setViewName("/success");
        mv.addObject("message", "成功调用后get方法！");
        return mv;
    }

    /**
     * <p>通过请求参数限定</p>
     * <p>访问的url：http://localhost:8080/param1/yuyu?userName=liaody&userPassword=123</p>
     *
     * @param validationType
     * @param userName
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "/param1/{validation}", params = {"userName!=administrator", "userPassword"})
    public ModelAndView param1(@PathVariable("validation") String validationType,
                               @RequestParam("userName") String userName,
                               @RequestParam("userPassword") String userPassword) {

        System.out.println("绑定参数设置{}：" + validationType);
        System.out.println("绑定参数userName：" + userName);
        System.out.println("绑定参数设置userPassword：" + userPassword);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/success");
        return mv;
    }

}