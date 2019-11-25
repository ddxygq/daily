package com.keguang.daily.flink.asyncio;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.keguang.daily.start.Configuration;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.AsyncDataStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: keguang
 * @ Date: 2019/9/9 15:24
 * @ version: v1.0.0
 * @ description:
 */
public class AsyncMysqlRequest {

    public static void main(String[] args) throws Exception {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Map<String, String> config = Configuration.initConfig("src/main/resources/manage-offset.xml");
        config.put("kafka-topic", "flink-kafka-test");
        // configure kafka
        Properties kafkaProps = new Properties();
        kafkaProps.setProperty("bootstrap.servers", config.get("kafka-ipport"));
        kafkaProps.setProperty("group.id","flink-kafka-test-async");
        kafkaProps.setProperty("auto.offset.reset", "earliest");

        FlinkKafkaConsumer010<String> consumer010 = new FlinkKafkaConsumer010<>(config.get("kafka-topic"), new SimpleStringSchema(), kafkaProps);

        DataStream<User> dataStream = env.addSource(consumer010)
                .map(val -> {
                    JSONObject jsonObject = JSON.parseObject(val);
                    String id = jsonObject.getString("id");
                    String username = jsonObject.getString("username");
                    String password = jsonObject.getString("password");

                    return new User(id, username, password);
                });

        // 异步IO 获取mysql数据, timeout 时间 1s，容量 10（超过10个请求，会反压上游节点）
        DataStream async = AsyncDataStream.orderedWait(dataStream, new AsyncFunctionForMysql(), 1000, TimeUnit.MILLISECONDS, 10);

        async.map(user -> user.toString()).print();

        env.execute("asyncForMysql");

    }
}
