package com.company.project.utils;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Aspect 日志切面
 */
@Aspect
@Component
public aspect LogAspect
{
    /**
     * slf4j切面日志
     */
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * cn.controller.*.*(..))")
    public void webLog(){};
    //





}
