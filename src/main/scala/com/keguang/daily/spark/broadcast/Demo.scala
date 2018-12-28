package com.keguang.daily.spark.broadcast

import com.keguang.daily.spark.utils.SparkUtils

/**
  * @ Author: keguang
  * @ Date: 2018/12/20 16:43
  * @ version: v1.0.0
  * @ description: 
  */
object Demo extends App{
  val sc = SparkUtils.getSc(true)
  val list = List("hello java")
  val broadcast = sc.broadcast(list)
  val lineRdd = sc.textFile("data/json/hm2.file")
  lineRdd.filter(line => {
    broadcast.value.contains(line)
  }).foreach(println)
  sc.stop()
}
