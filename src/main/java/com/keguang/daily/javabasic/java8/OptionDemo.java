package com.keguang.daily.javabasic.java8;

import java.util.Optional;

/**
 * @ Author: keguang
 * @ Date: 2019/3/30 17:25
 * @ version: v1.0.0
 * @ description:
 */
public class OptionDemo {
    public static void main(String[] args) {
        Optional<String> op = Optional.of("hello");

        // ofNullable 与 of 的区别是可以接受空值
        Optional<String> op2 = Optional.ofNullable(null);

        if(op.isPresent()){
            System.out.println(op.get());
        }

        if(op2.isPresent()){
            System.out.println(op2.get());
        }

        op.ifPresent(str -> System.out.println(str));
        op2.ifPresent(str -> System.out.println(str));

        System.out.println(op.orElse("no"));
        System.out.println(op2.orElse("no"));

        System.out.println(op.orElseGet(() -> "no"));
        System.out.println(op2.orElseGet(() -> "no"));
    }




}
