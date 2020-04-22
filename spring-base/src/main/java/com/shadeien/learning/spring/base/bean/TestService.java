package com.shadeien.learning.spring.base.bean;

import com.shadeien.learning.spring.base.TestAnnotation;
import com.shadeien.learning.spring.base.jpa.entity.DeviceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class TestService {
    @Autowired
    Set<BeanInterface> beanSet;
    @Autowired
    Map<String,BeanInterface> map;
    @Value("${depend}")
    String depend;

    public TestService() {
        System.out.println("TestService init"+depend);
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

    @TestAnnotation(name = "annotated")
    public void testAnnotation(HashMap<String, String> map, DeviceInfo deviceInfo) {

    }

    public void sayHello() {
        System.out.println("service hello"+depend);
        System.out.println("beanSet size:"+beanSet.size());
        for (BeanInterface bean : beanSet){
            bean.sayHello();
        }
        System.out.println("map keys:"+map.keySet());
    }
}
