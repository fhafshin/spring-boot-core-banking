package ir.setad.banking.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Before("@within(org.springframework.web.bind.annotation.RestController)")
    public void logBefore(JoinPoint jp) {

        System.out.println("method start :" + jp.getSignature());


    }

    @After("@within(org.springframework.web.bind.annotation.RestController)")
    public void logAfter(JoinPoint jp) {
        System.out.println("method end :" + jp.getSignature());
    }

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object logAround(ProceedingJoinPoint jp) throws Throwable {

        System.out.println("around start :" + jp.getSignature());
        try {
            Object result = jp.proceed();
            return result;
        } catch (Exception ex) {
            System.out.println("around exception :" + ex.getMessage());
            throw ex;
        }


    }


}
