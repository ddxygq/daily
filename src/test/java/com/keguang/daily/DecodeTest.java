package com.keguang.daily;

import com.keguang.daily.utils.DecodeUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @version v1.0.0
 * @Author:keguang
 * @Date:2018/8/21 16:09
 */
public class DecodeTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        String s = "activex����'ҫ?:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
        String decs = DecodeUtil.decode(s, "utf8");
        System.out.println(decs);

        String s2 = new String(s.getBytes("ISO-8859-1"), "utf-8");
        System.out.println(s2);
    }
}
