package com.keguang.daily.annotation;

/**
 * @ Author: keguang
 * @ Date: 2019/2/18 10:41
 * @ version: v1.0.0
 * @ description: 注解的提取
 */

@TestAnnotation(msg="hello annotation.")
public class GetAnnotation {

    // 通过反射获取注解
    public static void main(String[] args) {
        boolean hasAnnotation = GetAnnotation.class.isAnnotationPresent(TestAnnotation.class);

        if(hasAnnotation){
            TestAnnotation testAnnotation = GetAnnotation.class.getAnnotation(TestAnnotation.class);

            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }

    }
}
