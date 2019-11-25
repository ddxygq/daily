package com.keguang.daily.flink.asyncio;

import com.ddxygq.bigdata.utils.MysqlPoolUtils;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.async.ResultFuture;
import org.apache.flink.streaming.api.functions.async.RichAsyncFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @ Author: keguang
 * @ Date: 2019/9/9 15:24
 * @ version: v1.0.0
 * @ description:
 */
public class AsyncFunctionForMysql extends RichAsyncFunction<User, User> {

    Logger logger = LoggerFactory.getLogger(AsyncFunctionForMysql.class);
    private transient Connection conn;
    private static PreparedStatement ps;
    private transient ExecutorService executorService;

    /**
     * 初始化连接
     * @param parameters
     * @throws Exception
     */
    @Override
    public void open(Configuration parameters) throws Exception {
        logger.info("async function for mysql java open ...");
        super.open(parameters);
        conn = MysqlPoolUtils.getConnection();
        ps = conn.prepareStatement("select phone from test.async where id = ?");
        executorService = Executors.newFixedThreadPool(30);
    }

    @Override
    public void close() throws Exception {
        logger.info("async function for mysql java close ...");
        super.close();
        executorService.shutdown();
    }

    @Override
    public void timeout(User input, ResultFuture<User> resultFuture) throws Exception {

        logger.warn("timeout ...");
        List<User> list = new ArrayList<>();
        input.setPhone("timeout");
        list.add(input);
        resultFuture.complete(list);

    }

    @Override
    public void asyncInvoke(User input, ResultFuture<User> resultFuture) throws Exception {
        CompletableFuture.supplyAsync(new Supplier<User>() {
            @Override
            public User get() {
                // String phone = "00";
                try {
                    ps.setString(1, input.getId());
                    ResultSet rs = ps.executeQuery();
                    if (!rs.isClosed() && rs.next()) {
                        input.setPhone(rs.getString(1));
                    }
                    System.out.println("execute query : id -> " + input.getId() + ", phone -> " + input.getPhone() + ", timestamp -> " + System.currentTimeMillis());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // input.setPhone(phone);
                return input;
            }
        }).thenAccept((User user) -> {
            resultFuture.complete(Collections.singletonList(user));
        });
    }
}
