package com.keguang.daily;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0.0
 * @Author:keguang
 * @Date:2018/11/1 14:29
 */
public class Test2 {

    @Test
    public void test(){
        Map<String, String> map = new HashMap<>();
        map.put("kg", "1");
        map.put("Kg", "2");
        System.out.println(map);
    }
}
