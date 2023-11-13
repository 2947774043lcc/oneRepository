package com.yuntu.aopLog;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.aopLog
 * @Author: Shuo
 * @CreateTime: 2023-10-09  11:20
 * @Description:
 * @Version: 1.0
 */
/*@Aspect*/
public class ServiceLogger {
    private static final Logger log = Logger.getLogger(ServiceLogger.class);


    /*
    * JoinPoint:连接点的对象
    * JoinPoint.getTarget():连接点方法所在的目标类
    * JoinPoint.getSignature():连接点方法的信息
    * JoinPoint.getArgs():连接带你方法参数数组
    * Object result : 方法返回值
    * */
    public void before(JoinPoint joinPoint){
/*     log.debug("调用"+joinPoint.getTarget()+"的"+
             joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs()));*/
        System.out.println("调用"+joinPoint.getTarget()+"的"+
                joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs()));
    }

    public void after(JoinPoint joinPoint,Object result){
/*        log.debug("调用"+joinPoint.getTarget()+"的"+
                joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs())+"返回值"+result);*/
        System.out.println("调用"+joinPoint.getTarget()+"的"+
                joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs())+"返回值"+result);
    }

    /*环绕增强*/
    public Object aroundLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("调用了"+joinPoint.getTarget()+"方法,环绕前置");
        //执行切入点
        Object result = joinPoint.proceed();
        System.out.println("调用了"+joinPoint.getTarget()+"方法,环绕后置");
        return result;
    }

    public void afterThrow(JoinPoint joinPoint,RuntimeException e){
        System.out.println(joinPoint.getSignature().getName()+"的方法发生了"+e+"的异常");
    }
}
