package com.yuntu.aopLog;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.aopLog
 * @Author: Shuo
 * @CreateTime: 2023-10-09  14:41
 * @Description:
 * @Version: 1.0
 */
public class AfterLog implements AfterReturningAdvice {


    /*
    *   o 返回值
    *   method 目标方法
    *   objects 参数
    *   o1 目标类
    *   Throwable
    * */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+method.getName()+"的方法,返回值是"+o);
    }
}
