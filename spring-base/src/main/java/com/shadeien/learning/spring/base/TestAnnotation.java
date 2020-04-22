package com.shadeien.learning.spring.base;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String name() default "";
}
