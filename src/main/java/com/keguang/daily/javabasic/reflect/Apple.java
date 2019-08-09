package com.keguang.daily.javabasic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ Author: keguang
 * @ Date: 2019/7/30 14:54
 * @ version: v1.0.0
 * @ description:
 */
public class Apple {
    private int price;

    public String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 正常调用
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("apple price : " + apple.getPrice());

        // 反射
        Class clz = Class.forName("com.keguang.daily.javabasic.reflect.Apple");
        Method setMethod = clz.getMethod("setPrice", int.class);
        Constructor constructor = clz.getConstructor();
        Object obj = constructor.newInstance();
        setMethod.invoke(obj, 14);
        Method getMethod = clz.getMethod("getPrice");
        System.out.println("apple price : " + getMethod.invoke(obj));


        Class clz2 = Apple.class;
        // Field[] fields = clz2.getFields();
        Field[] fields = clz2.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }

        Class clz3 = apple.getClass();
        Field[] fields2 = clz3.getDeclaredFields();
        for(Field field : fields2){
            System.out.println(field.getName());
        }

        Method[] methods = clz3.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }

    }
}
