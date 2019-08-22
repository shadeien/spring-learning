package com.shadeien.learning.spring.base;

import com.shadeien.learning.spring.base.bean.TestBean;
import com.shadeien.learning.spring.base.bean.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);

        // 如果加载spring-context.xml文件：
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("spring-context.xml");

        //获取bean
        TestService tb = context.getBean(TestService.class);
        tb.sayHello();
    }
}
