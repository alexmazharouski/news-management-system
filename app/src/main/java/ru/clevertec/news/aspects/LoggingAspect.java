package ru.clevertec.news.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Slf4j
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* ru.clevertec.news.controllers..*(..))")
    private void logAllMethods() {

    }

    @AfterReturning(pointcut = "logAllMethods()", returning = "result")
    public void logMethods(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();
        log.info("{} parameters {}", methodName, Arrays.toString(parameters));
        log.info("{} returned {}", methodName, result);
    }
}
