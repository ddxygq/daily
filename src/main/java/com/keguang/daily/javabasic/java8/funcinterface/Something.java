package com.keguang.daily.javabasic.java8.funcinterface;

/**
 * @ Author: keguang
 * @ Date: 2019/10/14 14:27
 * @ version: v1.0.0
 * @ description: Java 8允许您通过::关键字传递[方法]或[构造函数]的引用。
 */
public class Something {
    String startsWith(String s){
        return String.valueOf(s.charAt(0));
    }


    public static void main(String[] args) {
        Something something = new Something();
        FuncInter<String, String> funcInter = something::startsWith;
        String funcIntered = funcInter.f("keguang");
        System.out.println(funcIntered);
    }
}
