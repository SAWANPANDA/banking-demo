package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // Logs all methods in the controller package
    @Around("within(com.example.demo.controller..*)")
    public Object logRequestResponse(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        log.info("➡ Entering Method: " + methodName);
        log.info("➡️ Request Args: ");

        for (Object arg : args) {
            log.info("   → " + arg);
        }

        Object result = joinPoint.proceed();

        log.info("⬅️ Exiting Method: " + methodName);
        log.info("⬅️ Response: " + result);

        return result;
    }
}