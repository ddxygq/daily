package com.keguang.daily.json.module2Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * @ Author: keguang
 * @ Date: 2019/7/1 14:45
 * @ version: v1.0.0
 * @ description:
 */
public class Module2Json {

    public static void main(String[] args) {
        String s = "{\"name\":\"keguang\", \"age\":24}";

        People people = JSON.parseObject(s, new TypeReference<People>(){});
        System.out.println(people.toString());

    }
}
