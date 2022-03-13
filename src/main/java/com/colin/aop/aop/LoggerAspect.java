package com.colin.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面
 */
@Component
@Aspect
public class LoggerAspect {
    @Pointcut("execution(* com.colin.aop.aop.impl.*DaoImpl.insert*(..)) ||" +
            "execution(* com.colin.aop.aop.impl.*DaoImpl.delete*(..)) ||" +
            "execution(* com.colin.aop.aop.impl.*DaoImpl.update*(..))")
    private void daoPointCut() {} // the pointcut signature

//    @Before("daoPointCut()")
    public void before(){
        Logger.info("前置通知");
    }

//    @After("daoPointCut()")
    public void after(){
        Logger.info("后置通知");
    }

    @AfterThrowing("daoPointCut()")
    public void throwing(){
        Logger.info("异常通知");
    }

//    @AfterReturning("daoPointCut()")
    public void returning(){
        Logger.info("最终通知");
    }

//    @Around("daoPointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        Logger.info("环绕之前");
        //这个方法相当于目标对象中的对应方法的调用。
        pjp.proceed();
        Logger.info("环绕之后");
    }
}
