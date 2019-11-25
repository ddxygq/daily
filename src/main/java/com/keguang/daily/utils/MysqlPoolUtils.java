package com.keguang.daily.utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author: keguang
 * @ Date: 2019/10/23 17:13
 * @ version: v1.0.0
 * @ description:
 */
public class MysqlPoolUtils {

    private static BasicDataSource bs  = null;

    public static BasicDataSource getBasicDataSource(){
        if(bs  == null){
            bs = new BasicDataSource();
            bs.setDriverClassName("com.mysql.jdbc.Driver");
            bs.setUrl("jdbc:mysql://localhost:3306/test");
            bs.setUsername("root");
            bs.setPassword("root");
            bs.setMaxActive(20);           // 设置最大并发数
            bs.setInitialSize(10);         // 数据库初始化时，创建的连接个数
            bs.setMinIdle(10);             // 在不新建连接的条件下，池中保持空闲的最少连接数。
            bs.setMaxIdle(10);             // 池里不会被释放的最多空闲连接数量。设置为0时表示无限制。
            bs.setMaxWait(5000);          // 在抛出异常之前，池等待连接被回收的最长时间（当没有可用连接时）。设置为-1表示无限等待。
            bs.setMinEvictableIdleTimeMillis(10*1000);     // 空闲连接5秒中后释放
            bs.setTimeBetweenEvictionRunsMillis(1*60*1000);      //1分钟检测一次是否有死掉的线程
            bs.setTestOnBorrow(true);
        }

        return bs ;
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = getBasicDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


}
