package com.immoc.demo.aspect.imooc.dynamic;

import com.immoc.demo.aspect.imooc.RealSubject;
import com.immoc.demo.aspect.imooc.Subject;
import com.sun.deploy.util.SessionState;

import java.lang.reflect.Proxy;

/**
 * @author: LXH
 * @create: 2018/7/5
 */
public class Clinet {

    public static void main(String args[]){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = (Subject) Proxy.newProxyInstance(SessionState.Client.class.getClassLoader(),new Class[]{Subject.class},new JdkProxySubject(new RealSubject()));
        System.out.println(subject.getClass());
        subject.hello();
    }
}
