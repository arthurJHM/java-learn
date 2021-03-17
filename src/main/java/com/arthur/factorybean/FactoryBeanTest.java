package com.arthur.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @title: FactoryBeanTest
 * @Author ArthurJi
 * @Date: 2021/3/16 16:46
 * @Version 1.0
 */
public class FactoryBeanTest implements FactoryBean<Object> , InitializingBean {
    public static void main(String[] args) {

//        new AbstractBeanFactory();

    }


    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
