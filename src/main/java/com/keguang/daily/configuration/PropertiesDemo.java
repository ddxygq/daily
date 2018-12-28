package com.keguang.daily.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

/**
 * 读取.proeprties文件
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("src/main/resources/sys-config.properties");
        properties.load(inputStream);
        // iter里面包含properties文件的所有的key
        Iterator<String> iter = properties.stringPropertyNames().iterator();
        String drivername = properties.getProperty("driver-name");
        String url = properties.getProperty("url");
        String username = properties.getProperty("user-name");
        String password = properties.getProperty("password");

        System.out.println(drivername);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
