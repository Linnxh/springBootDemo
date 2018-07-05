package com.immoc.demo.aspect;
import org.aspectj.lang.JoinPoint;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: LXH
 * @create: 2018/7/3
 * 切面处理类
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.immoc.demo.web.AreaController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinpoint) {
     ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //日志记录：url method ip 类方法 参数
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName());
        logger.info("args={}",joinpoint.getArgs());


    }

    @After("log()")
    public void doAfter() {

    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void afterReturn(Object object){
        logger.info("response={}",object);
    }

}

