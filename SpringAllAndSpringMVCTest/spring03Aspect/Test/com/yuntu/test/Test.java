package com.yuntu.test;

import com.yuntu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.test
 * @Author: Shuo
 * @CreateTime: 2023-10-09  10:59
 * @Description:
 * @Version: 1.0
 */
public class Test {
    @org.junit.Test
    public void userServiceTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.getUserList();

    }

    @org.junit.Test
    public void userServiceTest2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.getUserList();

    }
    @org.junit.Test
    public void userServiceTest3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.getUserList();

    }
}
