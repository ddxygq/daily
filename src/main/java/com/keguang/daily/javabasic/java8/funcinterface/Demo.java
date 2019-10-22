package com.keguang.daily.javabasic.java8.funcinterface;

/**
 * @ Author: keguang
 * @ Date: 2019/10/14 14:03
 * @ version: v1.0.0
 * @ description:
 */
public class Demo {

    public static void main(String[] args) {
        FuncInter<String, Integer> funcInter = (from) -> Integer.valueOf(from);
        Integer t = funcInter.f("123");
        System.out.println(t);

        FuncInter<String, Integer> funcInter1 = Integer::valueOf;
        Integer t1 = funcInter1.f("111");
        System.out.println(t1);

        PersonFactory<Person> personPersonFactory = Person::new;
        Person person = personPersonFactory.create("guang", "ke");
    }
}
