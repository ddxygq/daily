package com.keguang.daily.javabasic.hash;

/**
 * @ Author: keguang
 * @ Date: 2019/2/13 11:51
 * @ version: v1.0.0
 * @ description:
 */
public class Demo {
    public static void main(String[] args) {
        demo();
    }

    private static void demo(){
        String s = "META-INF";
        String s2 = "META-INF";
        System.out.println(s == s2);
        System.out.println(s == "META-INF");
    }
}
