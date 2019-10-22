package com.keguang.daily.javabasic.java8.funcinterface;

/**
 * @ Author: keguang
 * @ Date: 2019/10/14 14:44
 * @ version: v1.0.0
 * @ description:
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
