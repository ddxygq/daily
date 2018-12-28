package com.keguang.daily.decode;

import com.keguang.daily.utils.DecodeUtil;

import java.io.UnsupportedEncodingException;

/**
 * @version v1.0.0
 * @Author:keguang
 * @Date:2018/7/27 9:29
 */
public class Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "\u0041";
        String des = DecodeUtil.decode(s,"utf-8");
        System.out.println(des);
    }
}
