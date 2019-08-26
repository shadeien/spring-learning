package com.shadeien.learning.spring.base;

import com.shadeien.learning.spring.base.bean.TestBean;
import com.shadeien.learning.spring.base.bean.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = "com.shadeien.learning.spring.base")
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringApplicationTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApplicationTest.class, args);
        TestService tb = context.getBean(TestService.class);
        tb.sayHello();
    }
}
