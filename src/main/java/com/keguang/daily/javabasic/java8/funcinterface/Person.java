package com.keguang.daily.javabasic.java8.funcinterface;

/**
 * @ Author: keguang
 * @ Date: 2019/10/14 14:36
 * @ version: v1.0.0
 * @ description:构造函数是如何使用::关键字来引用
 */
public class Person {

    String firstName;
    String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
