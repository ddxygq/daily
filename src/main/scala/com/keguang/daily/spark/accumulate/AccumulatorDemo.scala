package com.keguang.daily.spark.accumulate

import com.keguang.daily.spark.utils.SparkUtils

/**
  * @Author:keguang
  * @Date:2018 /8/7 11:58
  * @version v1.0.0
  */
object AccumulatorDemo extends App {
  val sc = SparkUtils.getSc(true)

  val accum = sc.longAccumulator("count")

  val data = sc.parallelize(0.to(10),2)
  data.foreachPartition(p => {
    p.foreach(e => {
      // println("\"\"" + e)
      accum.add(1)
    })
  })

  // Thread.sleep(1000)
  println(accum.value)


}
