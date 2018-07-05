package com.immoc.demo.aspect.imooc.cglib;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: LXH
 * @create: 2018/7/5
 */
public class DemoMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before in cglib");
        Object result = null;
        result = proxy.invokeSuper(obj, args);
        System.out.println("after in cglib");
        return result;
    }
}
