package com.lxy.springMVC.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AspectExample {

    /**
     * 定义切入点
     *
     * 切入点表达式格式为：【修饰符匹配】返回值匹配【类的路径匹配】方法名匹配(参数匹配)  【】表示可选
     * 修饰符匹配（可选）：java的访问控制修饰符
     * 返回值匹配（必填）：int返回值表示int，* 表示任意返回值
     * 类的路径匹配（可选）：com.lxy.springMVC.controller.MvcController或者com.lxy.springMVC.controller.*
     * 方法名匹配（必填）：xxx表示xxx方法，*表示所有方法，set*表示以set开头的所有方法，*xxx表示以xxx为结尾的方法
     * 参数匹配（必须）：(String)表示匹配一个String参数的方法; (*,String) 表示匹配有两个参数的方法，第一个参数可以是任意类型，而第二个参数是String类型; (..)表示零个或多个任意参数
     */
    // PointCut表达式
    @Pointcut("execution(public * com.lxy.springMVC.controller.MvcController.*(..))")
    //PointCut签名
    public void controllerAspect(){
        // 切入点方法不应该写任何程序
    }

    /**
     * 预处理方法，本方法是在被代理方法执行前执行
     * @param joinPoint 接入点
     */
    // 指定签名
    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("before");
//        joinPoint.getArgs():获取被代理的目标类
//        joinPoint.getSignature() 获取被代理的目标方法
//        joinPoint.getArgs() 获取被代理方法的参数 返回值是Object类型的数组
        System.out.printf("%s","Before:"+joinPoint.getSignature().getName());
    }

    /**
     * 后处理，本方法在被代理方法执行后执行
     * @param joinPoint 接入点
     * @param retVal 返回值
     */
    @AfterReturning(pointcut="controllerAspect()",returning = "retVal")
    public void afterReturning(JoinPoint joinPoint,Object retVal){
        System.out.println("AfterReturning:"+joinPoint.getSignature().getName());
        System.out.println(retVal);
    }

    /**
     * 后处理，本方法在被代理方法抛出异常后执行
     * @param joinPoint 接入点
     * @param ex 抛出异常
     */
    @AfterThrowing(pointcut = "controllerAspect()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        System.out.println("AfterThrowing:"+joinPoint.getSignature().getName());
        System.out.println(ex.getMessage());
    }

    /**
     * 后处理，本方法在被代理方法执行完成后者抛出异常后执行
     * @param joinPoint 接入点
     */
    @After("controllerAspect()")
    public void after(JoinPoint joinPoint){
        System.out.println("After"+joinPoint.getSignature().getName());
    }


    /**
     * 环绕处理，本方法在被代理方法执行前执行，本方法内可使用pjp调用被代理方法
     * @param pjp 接入点
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        // 如果添加了before方法，运行到这里则会运行before方法，或者这里可以添加"Before"对应逻辑
        /**
         * 如果切面拦截的是Controller时，可以用下面代码获取HttpServletRequest以及HttpServletResponse
         */
//        获取HttpServletRequest
//        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
//        获取HttpServletResponse
//        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
        // 调用被代理的方法
        Object retVal = pjp.proceed();
        // 如果添加了after方法，运行到这里会运行after相关方法，或者这里可以添加"After"对应逻辑
        return retVal;
    }
}
