package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    @Before("execution(* housework())")
    public void before(JoinPoint joinPoint){
        System.out.println("before");
        System.out.println(joinPoint);
    }

    @After("execution(public void aop.Boy.housework())")
    public void after(JoinPoint joinPoint){
        System.out.println("after");
    }
}
