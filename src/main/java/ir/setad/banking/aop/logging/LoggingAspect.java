package ir.setad.banking.aop.logging;

import ir.setad.banking.config.AppConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Environment env;

    public LoggingAspect(Environment env) {
        this.env = env;
    }


    @Pointcut(
            "within(@org.springframework.stereotype.Repository *)" +
                    " || within(@org.springframework.stereotype.Service *)" +
                    " || within(@org.springframework.web.bind.annotation.RestController *)"
    )
    public void springBeanPointCut() {
    }

    @Pointcut("within(ir.setad.banking.repository..*)" +
            " || within(ir.setad.banking.domain..*)" +
            " || within(ir.setad.banking.service..*)" +
            " || within(ir.setad.banking.web.rest..*)")

    public void applicationPackagePointCut() {

    }

    @AfterThrowing(pointcut = "applicationPackagePointCut() && springBeanPointCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {

        if (env.acceptsProfiles(Profiles.of(AppConstants.SPRING_PROFILE_DEVELOPMENT)))
        {
            logger(joinPoint)
                    .error("exception in {} with cause = {} and exception = {}"
                            , joinPoint.getSignature().getName(),
                            e.getCause() != null ? e.getCause() : "null", e.getMessage(), e);
        }
        else
        {
            logger(joinPoint)
                    .error("exception in {} with cause = {} and exception = {}"
                            , joinPoint.getSignature().getName(),
                            e.getCause() != null ? e.getCause() : "null", e.getMessage(), e);
        }


    }


    @Around( "applicationPackagePointCut() && springBeanPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = logger(joinPoint);
        if (log.isDebugEnabled()) {
            log.debug("enter {}() with arguments[s]={}", joinPoint.getSignature().getDeclaringTypeName(), Arrays.toString(joinPoint.getArgs()));
        }

        try {

            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("exit {}() with result={}", joinPoint.getSignature().getDeclaringTypeName(), result);

            }
            return result;
        } catch (Exception ex) {
            log.error("Illegal argument:{} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getDeclaringTypeName());
            throw ex;
        }

    }

    private Logger logger(JoinPoint joinPoint) {


        return LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
    }
}
