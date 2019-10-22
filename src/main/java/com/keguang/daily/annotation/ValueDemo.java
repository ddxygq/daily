package com.keguang.daily.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author: keguang
 * @ Date: 2019/9/26 13:43
 * @ version: v1.0.0
 * @ description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueDemo {

    String value();
}
