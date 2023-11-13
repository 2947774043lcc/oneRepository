package com.yuntu.aopLog;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.aopLog
 * @Author: Shuo
 * @CreateTime: 2023-10-09  14:37
 * @Description:
 * @Version: 1.0
 */
public class BeforeLog implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("调用"+o.getClass().getName()+"的"+method.getName()+"方法");
    }
}
