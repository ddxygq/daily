package com.keguang.daily.javabasic.collections;

import java.util.Arrays;
import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/11/19 14:04
 * @ version: v1.0.0
 * @ description:
 */
public class ListDemo {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        List list = Arrays.asList(ints);
        // size -> 1
        System.out.println(list.size());

        Integer[] ints2 = {1, 2, 3, 4, 5};
        List list2 = Arrays.asList(ints2);
        // size -> 5
        System.out.println(list2.size());

        list2.add(6);
    }
}
