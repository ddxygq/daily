package com.keguang.daily.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ Author: keguang
 * @ Date: 2019/9/26 14:33
 * @ version: v1.0.0
 * @ description:
 */
@AnnotationDemo(msg = "hello")
public class AllTest {

    @ValueDemo("hi")
    int a;

    @Perform
    public void testMethod(){}

    @SuppressWarnings("deprecation")
    public void test(){
        DeprecatedDemo deprecatedDemo = new DeprecatedDemo();
        deprecatedDemo.hi();
        deprecatedDemo.hello();
    }

    public static void main(String[] args) {
        Field a = null;
        try {
            a = AllTest.class.getDeclaredField("META-INF");
            a.setAccessible(true);

            // 获取成员变量上的注解
            ValueDemo valueDemo = a.getAnnotation(ValueDemo.class);

            if (valueDemo != null){
                System.out.println("value is " + valueDemo.value());
            }

            Method method = AllTest.class.getDeclaredMethod("testMethod");

            if (method != null){
                Annotation[] ans = method.getAnnotations();
                System.out.println(ans.length);
                for(int i = 0;i < ans.length;i++){
                    System.out.println("method annotation:" + ans[i].annotationType().getSimpleName());
                }
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }

    }



}
