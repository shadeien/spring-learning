package com.shadeien.learning.spring.base.bean;

import org.springframework.stereotype.Component;

@Component
public class BeanImplOne implements BeanInterface {
    @Override
    public void sayHello() {
        System.out.println("BeanImplOne");
    }
}
