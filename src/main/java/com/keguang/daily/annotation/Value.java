package com.keguang.daily.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author: keguang
 * @ Date: 2019/9/26 15:10
 * @ version: v1.0.0
 * @ description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {

    String value();
}
