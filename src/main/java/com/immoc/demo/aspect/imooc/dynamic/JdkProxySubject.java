package com.immoc.demo.aspect.imooc.dynamic;

import com.immoc.demo.aspect.imooc.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: LXH
 * @create: 2018/7/5
 */
public class JdkProxySubject implements InvocationHandler {


    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JdkProxySubject 的invoke() before");
        Object result = null;
        result = method.invoke(realSubject, args);
        System.out.println("JdkProxySubject 的invoke() after");
        return result;
    }
}
