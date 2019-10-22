package com.keguang.daily.annotation;

/**
 * @ Author: keguang
 * @ Date: 2019/9/26 13:45
 * @ version: v1.0.0
 * @ description: 只有一个名为value的属性时，可以直接传入值，省去"value = "
 */
@Value("test")
public class ValueDemoTest {
    public static void main(String[] args) {

        // 判断它是否应用了某个注解
        boolean hasAnnotation = ValueDemoTest.class.isAnnotationPresent(Value.class);

        if(hasAnnotation){

            // 通过 getAnnotation() 方法来获取 Annotation 对象
            Value value = ValueDemoTest.class.getAnnotation(Value.class);

            System.out.println(value.value());
        }
    }
}
