package com.yuntu.controller;

import com.yuntu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.controller
 * @Author: Shuo
 * @CreateTime: 2023-10-23  15:14
 * @Description:
 * @Version: 1.0
 */
@Controller
public class UserController{
    @RequestMapping("/index")
      public String index(){
          System.out.println("注解进入接口");
          return "index";
      }

    @RequestMapping("/index1")
    public String index1(){
        System.out.println("注解进入接口");
        return "index1";
    }

    //2.参数的传递
    //2.1 view to controller

    //get请求  地址栏上发送的请求  参数用?拼接
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(@RequestParam(value = "userName",required = false) String userName){
        System.out.println("欢迎登录"+userName);
        return "index";
    }

    //2.2  controller to view
    @RequestMapping(value = "/hello")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName","李四");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/hello2")
    public ModelAndView hello2(@RequestParam(value = "userName",required = false) String userName){
        ModelAndView modelAndView = new ModelAndView();
        //addObject(attributeName,attributeName)
        //attributeName 作为key 在前端进行${key} 来回显数据
        //attributeName 没有写 在前端需要通过${参数类型}来回显数据
        modelAndView.addObject("userName",userName);
        modelAndView.addObject(userName);
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping(value = "/getUser")
    public ModelAndView getUser(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUserName("翠花");
        modelAndView.addObject("student",user);
        modelAndView.addObject(user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/getUserList")
    public ModelAndView getUserList(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUserName("翠花");
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("student1",user);
        hashMap.put("student2","张三");
        hashMap.put("student3","李四");
        modelAndView.addAllObjects(hashMap);
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
