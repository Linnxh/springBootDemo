package com.immoc.demo.aspect.imooc;

/**
 * @author: LXH
 * @create: 2018/7/5
 */
public class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("RealSubject 的request()方法--------------  ");
    }

    @Override
    public void hello() {
        System.out.println("RealSubject hello()方法-----------------  ");
    }
}
