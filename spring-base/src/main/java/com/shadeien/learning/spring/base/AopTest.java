package com.shadeien.learning.spring.base;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {
    private final String key = "execution(* com.shadeien.learning.spring.base.bean.TestService.*(..))";

    @Around(key)
    public Object doAround(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("doAround before");
            Object result = joinPoint.proceed();
            System.out.println("doAround after");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
