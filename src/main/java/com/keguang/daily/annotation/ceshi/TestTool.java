package com.keguang.daily.annotation.ceshi;

import java.lang.reflect.Method;

/**
 * @ Author: keguang
 * @ Date: 2019/9/26 17:00
 * @ version: v1.0.0
 * @ description:
 */
public class TestTool {

    public static void main(String[] args) {

        NoBug  testobj = new NoBug();

        Class clazz = testobj.getClass();

        Method[] method = clazz.getDeclaredMethods();

        StringBuilder log = new StringBuilder();
        int errornum = 0;

        for(Method m : method){
            if(m.isAnnotationPresent(JianCha.class)){
                try{
                    m.setAccessible(true);
                    m.invoke(testobj, null);
                }catch (Exception e){
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }

        log.append(clazz.getSimpleName());
        log.append(" has ");
        log.append(errornum);
        log.append(" error.");

        System.out.println(log.toString());


    }
}
