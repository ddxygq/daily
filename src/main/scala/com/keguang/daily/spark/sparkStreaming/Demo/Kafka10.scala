package com.keguang.daily.spark.sparkStreaming.Demo

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @Author:keguang
  * @Date:2018 /10/26 17:51
  * @version v1.0.0
  */
object Kafka10 extends App {
  val conf = new SparkConf().setAppName("spark-kafka-10").setMaster("local[*]")
  val ssc = new StreamingContext(conf, Seconds(5))
  val zkQuorm = "qcloud-test-hadoop01:9092"
  val topics = Array("tongji-flash-hm2")
  val topicSet = Set(topics)

  val kafkaParams = Map[String, Object](
    "bootstrap.servers" -> zkQuorm
    ,"group.id" -> ("daily" + "_group-")
    ,"key.deserializer" -> classOf[StringDeserializer]
    ,"value.deserializer" -> classOf[StringDeserializer]
    ,"auto.offset.reset" -> "earliest"
    ,"enable.auto.commit" -> (true:java.lang.Boolean)
  )

  val message:InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream(ssc, LocationStrategies.PreferConsistent, ConsumerStrategies.Subscribe[String, String](topics, kafkaParams))

  message.foreachRDD(rdd => {
    val rdd2 = rdd.map(x => (x.topic(), x.partition(), x.offset(), x.key(), x.value()))
    rdd2.collect().foreach(println)
    println(rdd.count())
  })

  println(message.count())

  ssc.start()
  ssc.awaitTermination()
  ssc.stop()


}
