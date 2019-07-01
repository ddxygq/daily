package com.keguang.daily.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author: keguang
 * @ Date: 2019/2/18 10:33
 * @ version: v1.0.0
 * @ description: 注解demo
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationDemo {

    // 注解的属性默认值需要用default关键字指定
    int id() default -1;

    String msg();
}
