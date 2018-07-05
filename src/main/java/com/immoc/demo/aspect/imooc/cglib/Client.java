package com.immoc.demo.aspect.imooc.cglib;

import com.immoc.demo.aspect.imooc.RealSubject;
import com.immoc.demo.aspect.imooc.Subject;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: LXH
 * @create: 2018/7/5
 */
public class Client {

    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }
}
