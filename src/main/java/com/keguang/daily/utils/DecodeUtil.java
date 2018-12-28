package com.keguang.daily.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodeUtil {
    public static String decode(String str, String encode) throws UnsupportedEncodingException {
        if(str == null || "".equals(str)){
            return "null";
        }
        return URLDecoder.decode(str, encode);
    }
}
