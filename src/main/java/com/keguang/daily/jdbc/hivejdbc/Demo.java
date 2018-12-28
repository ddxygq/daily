package com.keguang.daily.jdbc.hivejdbc;

import com.google.common.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.sql.*;

/**
 * @version v1.0.0
 * @Author:keguang
 * @Date:2018/10/17 11:19
 */
public class Demo {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();

        Document document = reader.read(Resources.getResource("hive-config.xml"));

        Element config = document.getRootElement();
        Element dbinfo = config.element("db-info"); // 获得元素子节点

        // 驱动
        String drivername = dbinfo.element("driver-name").getText();
        // 数据库连接url
        String url = dbinfo.element("url").getText();
        // 用户名
        String username = dbinfo.element("user-name").getText();
        // 密码
        String password = dbinfo.element("password").getText();

        Connection conn = null;

        try {
            Class.forName(drivername);
            try {
                conn = DriverManager.getConnection(url);
                System.out.println(conn);
                String sql = "select count(1) from helper where dt = \"2018-10-16\" and hour = \"08\"";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    System.out.println("count : " + resultSet.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(conn != null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
