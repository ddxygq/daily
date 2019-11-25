package com.keguang.daily.flink.asyncio;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author: keguang
 * @ Date: 2019/9/9 15:25
 * @ version: v1.0.0
 * @ description:
 */
public class MysqlClient {

    private static String jdbcUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8&useSSL=true";
    private static String username = "root";
    private static String password = "root";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static java.sql.Connection conn;
    private static PreparedStatement ps;

    static {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            ps = conn.prepareStatement("select phone from test.async where id = ?");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * execute query
     *
     * @param user
     * @return
     */
    public User query1(User user) {
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        String phone = "00";
        try {
            ps.setString(1, user.getId());
            ResultSet rs = ps.executeQuery();
            if (!rs.isClosed() && rs.next()) {
                phone = rs.getString(1);
            }
            System.out.println("execute query : id -> " + user.getId() + ", phone -> " + phone + ", timestamp -> " + System.currentTimeMillis());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user.setPhone(phone);
        return user;

    }

    // 测试代码
    public static void main(String[] args) {
        MysqlClient mysqlClient = new MysqlClient();

        User asyncUser = new User();
        asyncUser.setId("001");
        long start = System.currentTimeMillis();
        asyncUser = mysqlClient.query1(asyncUser);

        System.out.println("end : " + (System.currentTimeMillis() - start));
        System.out.println(asyncUser.toString());
    }
}
