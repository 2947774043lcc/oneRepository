package com.yuntu.aopLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.aopLog
 * @Author: Shuo
 * @CreateTime: 2023-10-10  10:39
 * @Description:
 * @Version: 1.0
 */
@Aspect//标注当前类是一个切面
@Component
public class zjLog {


    @Before("execution(* com.yuntu.service..*(..))")
    public void before(JoinPoint joinPoint){
/*     log.debug("调用"+joinPoint.getTarget()+"的"+
             joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs()));*/
        System.out.println("调用"+joinPoint.getTarget()+"的"+
                joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.yuntu.service..*(..))")
    public void after(JoinPoint joinPoint){
/*        log.debug("调用"+joinPoint.getTarget()+"的"+
                joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs())+"返回值"+result);*/
        System.out.println("调用"+joinPoint.getTarget()+"的"+
                joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs()));
    }
    @Around("execution(* com.yuntu.service..*(..))")
    public Object aroundLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("调用了"+joinPoint.getTarget()+"方法,环绕前置");
        //执行切入点
        Object result = joinPoint.proceed();
        System.out.println("调用了"+joinPoint.getTarget()+"方法,环绕后置");
        return result;
    }

    @AfterReturning(value = "execution(* com.yuntu.service..*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
/*        log.debug("调用"+joinPoint.getTarget()+"的"+
                joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs())+"返回值"+result);*/
        System.out.println("调用"+joinPoint.getTarget()+"的"+
                joinPoint.getSignature().getName()+"方法,参数是"+ Arrays.toString(joinPoint.getArgs())+"返回值是:"+result);
    }

    @AfterThrowing(value = "execution(* com.yuntu.service..*(..))",throwing = "e")
    public void afterThrow(JoinPoint joinPoint,RuntimeException e){
        System.out.println(joinPoint.getSignature().getName()+"的方法发生了"+e+"的异常");
    }

}
