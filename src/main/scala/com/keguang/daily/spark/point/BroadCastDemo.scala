package com.keguang.daily.spark.point

import com.keguang.daily.spark.utils.SparkUtils

/**
  * @Author:keguang
  * @Date:2018 /7/31 16:41
  * @version v1.0.0
  */
object BroadCastDemo extends App {
  val sc = SparkUtils.getSc(true)

  val s = sc.broadcast("hello broad")

  val data = sc.parallelize(List("hello broad", "hello cast"))

  val data2 = data.filter(x => {
    x.equals(s.value)
  })

  data2.foreach(println)
}
