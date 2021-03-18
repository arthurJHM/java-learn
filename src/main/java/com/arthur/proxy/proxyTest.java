package com.arthur.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @title: proxyTest
 * @Author ArthurJi
 * @Date: 2021/3/18 11:21
 * @Version 1.0
 */
public class proxyTest {
    public static void main(String[] args) {
        serviceimplments serviceimplments = new serviceimplments();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(serviceimplments);
        serviceInterface proxyInstance = (serviceInterface) Proxy.newProxyInstance(serviceimplments.getClass().getClassLoader(), serviceimplments.getClass().getInterfaces(), myInvocationHandler);
        proxyInstance.out();
    }

    static class MyInvocationHandler implements InvocationHandler {
        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        Object target = new Object();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("拦截");
            Object result = method.invoke(target, args);
            System.out.println("拦截Hou ");
            return result;
        }
    }
}
