package com.keguang.daily.annotation;

/**
 * @ Author: keguang
 * @ Date: 2019/2/18 10:41
 * @ version: v1.0.0
 * @ description: 注解的提取
 */

@AnnotationDemo(msg="hello annotation.")
public class GetAnnotation {

    // 通过反射获取注解
    public static void main(String[] args) {
        boolean hasAnnotation = GetAnnotation.class.isAnnotationPresent(AnnotationDemo.class);

        if(hasAnnotation){
            AnnotationDemo testAnnotation = GetAnnotation.class.getAnnotation(AnnotationDemo.class);

            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }

    }
}
