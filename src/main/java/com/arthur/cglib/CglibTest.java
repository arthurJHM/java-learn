package com.arthur.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @title: CglibTest
 * @Author ArthurJi
 * @Date: 2021/3/18 11:47
 * @Version 1.0
 */
public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new myMethodInterception());
        enhancer.setSuperclass(Base.class);
        Base baseproxy = (Base)enhancer.create();
        baseproxy.add();
    }
    static class myMethodInterception implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before");
            methodProxy.invokeSuper(o, objects);
            System.out.println("after");
            return null;
        }

    }
}
