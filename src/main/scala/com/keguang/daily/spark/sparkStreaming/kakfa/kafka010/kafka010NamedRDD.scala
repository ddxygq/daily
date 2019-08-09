package com.keguang.daily.spark.sparkStreaming.kakfa.kafka010

import java.util.Properties

import org.apache.kafka.clients.consumer.{Consumer, KafkaConsumer}
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.{SparkConf, TaskContext}
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable
import collection.JavaConverters._

/**
  * @ Author: keguang
  * @ Date: 2019/7/22 15:44
  * @ version: v1.0.0
  * @ description: 
  */
object kafka010NamedRDD {

  def main(args: Array[String]) {
    //    创建一个批处理时间是2s的context 要增加环境变量
    val sparkConf = new SparkConf().setAppName("DirectKafkaWordCount").setMaster("local[*]")
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    ssc.checkpoint("/opt/checkpoint")

    //    使用broker和topic创建DirectStream
    val topicsSet = "test".split(",").toSet
    val kafkaParams = Map[String, Object]("bootstrap.servers" -> "mt-mdh.local:9093",
      "key.deserializer"->classOf[StringDeserializer],
      "value.deserializer"-> classOf[StringDeserializer],
      "group.id"->"test4",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit"->(false: java.lang.Boolean))

    // 没有接口提供 offset
    val messages = KafkaUtils.createDirectStream[String, String](
      ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](topicsSet, kafkaParams,getLastOffsets(kafkaParams ,topicsSet)))//
    var A:mutable.HashMap[String,Array[OffsetRange]] = new mutable.HashMap()

    val trans = messages.transform(r =>{
      val offsetRanges = r.asInstanceOf[HasOffsetRanges].offsetRanges
      A += ("rdd1"->offsetRanges)
      r
    }).countByWindow(Seconds(10), Seconds(5))
    trans.foreachRDD(rdd=>{

      if(!rdd.isEmpty()){
        val offsetRanges = A.get("rdd1").get//.asInstanceOf[HasOffsetRanges].offsetRanges

        rdd.foreachPartition { iter =>
          val o: OffsetRange = offsetRanges(TaskContext.get.partitionId)
          println(s"${o.topic} ${o.partition} ${o.fromOffset} ${o.untilOffset}")
        }

        println(rdd.count())
        println(offsetRanges)
        // 手动提交offset ，前提是禁止自动提交
        messages.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)

      }
      //       A.-("rdd1")
    })
    //    启动流
    ssc.start()
    ssc.awaitTermination()
  }
  def getLastOffsets(kafkaParams : Map[String, Object],topics:Set[String]): Map[TopicPartition, Long] ={
    val props = new Properties()
    props.putAll(kafkaParams.asJava)
    val consumer = new KafkaConsumer[String, String](props)
    consumer.subscribe(topics.asJavaCollection)
    paranoidPoll(consumer)
    val map = consumer.assignment().asScala.map { tp =>
      println(tp+"---" +consumer.position(tp))
      tp -> (consumer.position(tp))
    }.toMap
    println(map)
    consumer.close()
    map
  }
  def paranoidPoll(c: Consumer[String, String]): Unit = {
    val msgs = c.poll(0)
    if (!msgs.isEmpty) {
      // position should be minimum offset per topicpartition
      msgs.asScala.foldLeft(Map[TopicPartition, Long]()) { (acc, m) =>
        val tp = new TopicPartition(m.topic, m.partition)
        val off = acc.get(tp).map(o => Math.min(o, m.offset)).getOrElse(m.offset)
        acc + (tp -> off)
      }.foreach { case (tp, off) =>
        c.seek(tp, off)
      }
    }
  }

}
