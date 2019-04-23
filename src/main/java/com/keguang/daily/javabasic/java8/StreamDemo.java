package com.keguang.daily.javabasic.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ Author: keguang
 * @ Date: 2019/3/30 16:43
 * @ version: v1.0.0
 * @ description:
 */
public class StreamDemo {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "b", "c");
        // List<String> output = stream.map(String::toUpperCase).collect(Collectors.toList());
        stream.map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);



    }

    private static void streamDefine(){
        // 使用值构建
        Stream<String> stream = Stream.of("a", "b", "c");

        // 使用数组构建
        String[] strArray = new String[]{"a", "b", "c"};
        Stream<String> stream2 = Stream.of(strArray);
        Stream<String> stream3 = Arrays.stream(strArray);

        // 利用集合构建
        List<String> list = Arrays.asList(strArray);
        Stream<String> stream4 = list.stream();

        // 数值Stream
        IntStream intStream = IntStream.of(new int[]{1, 2, 3});
        IntStream intStream2 = IntStream.range(1, 3);
        IntStream intStream3 = IntStream.rangeClosed(1, 3);

        // stream 转换为其它类型
        Stream<String> streamTransform = Stream.of("hello","world","tom");
        // 1.转换为Array
        String[] strArrayTransform = streamTransform.toArray(String[]::new);
        // 2. 转换为collection
        List<String> list2 = streamTransform.collect(Collectors.toList());
    }
}
