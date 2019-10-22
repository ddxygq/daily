package com.keguang.daily.javabasic.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/3/30 16:26
 * @ version: v1.0.0
 * @ description: lammbda 表达式用法
 */
public class LambdaDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","tom","apple","bbc");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        Collections.sort(list, (String s1, String s2) -> {
            return s1.compareTo(s2);
        });

        Collections.sort(list, (s1,s2) -> s1.compareTo(s2));

        System.out.println(list);

        list.forEach(fruit -> System.out.println(fruit));
    }
}
