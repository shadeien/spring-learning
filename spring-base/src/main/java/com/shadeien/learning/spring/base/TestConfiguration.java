package com.shadeien.learning.spring.base;

import com.shadeien.learning.spring.base.bean.BeanImplOne;
import com.shadeien.learning.spring.base.bean.BeanImplTwo;
import com.shadeien.learning.spring.base.bean.TestBean;
import com.shadeien.learning.spring.base.bean.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestConfiguration {
    public TestConfiguration() {
        System.out.println("TestConfiguration容器启动初始化。。。");
    }

    // @Bean注解注册bean,同时可以指定初始化和销毁方法
    @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
    @Scope("prototype")
    public TestBean testBean() {
        return new TestBean();
    }

    @Bean
    @Primary
    public TestService testService() {
        return new TestService();
    }

    @Bean
    public BeanImplOne beanImplOne() {
        return new BeanImplOne();
    }

    @Bean
    public BeanImplTwo beanImplTwo() {
        return new BeanImplTwo();
    }
}
