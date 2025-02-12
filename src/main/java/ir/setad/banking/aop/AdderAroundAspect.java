package ir.setad.banking.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class AdderAroundAspect {

    public Object aroundAdvise(ProceedingJoinPoint pjp) throws Throwable {


        System.out.println("arguments : "+ Arrays.toString(pjp.getArgs()));

        final Object result=pjp.proceed();
        System.out.println("result in around :"+result);
        return result;
    }
}
