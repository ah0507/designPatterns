package com.chensee.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author gaohang
 * @title: AoundAnnotationAspect
 * @projectName DesignPatterns
 * @date 2019/10/12 16:32
 */
@Aspect
@Component
public class AoundAnnotationAspect {

    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* yxm.zyf.love.service.impl.*.*(..))")'
     */
    @Pointcut("@annotation(com.chensee.aop.AoundAnnotation)")
    public void operationLog(){
    }

//    /**
//     * 环绕通知
//     */
//    @Around("operationLog()")
//    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        boolean b = false;
//        System.out.println("进入切面");
//        return (boolean) joinPoint.proceed();
//        //return b;
//    }

    /**
     * 环绕通知
     */
    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("进入切面");
        Object[] args = joinPoint.getArgs();
        Object[] objects = new Object[args.length];
        for (Object object : args) {
            System.out.println(object);
        }
        objects[0]="aaa";
        objects[1]=123456;
//        if (objects.length > 0) {
//            throw new Exception();
//        }
//        return false;
        return joinPoint.proceed(objects);
    }

    /**
     * 进入业务方法前
     * */
    @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        System.out.println("进入方法前执行.....");
    }

    /**
     * 处理完请求，返回内容
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "operationLog()")
    public void doAfterReturning(Object ret) {
        System.out.println("方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing(pointcut = "operationLog()",throwing = "ex")
    public void throwss(JoinPoint jp,Throwable ex){
        System.out.println("方法异常时执行....."+ex.toString());
        System.out.println("方法异常时执行.....");
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("operationLog()")
    public void after(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }
}
