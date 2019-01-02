package com.keguang.daily.spark.core.shuffle

import com.keguang.daily.spark.utils.SparkUtils

/**
  * @ Author: keguang
  * @ Date: 2018/12/28 14:25
  * @ version: v1.0.0
  * @ description: spark shuffle 应用
  */
object Demo extends App{
  val sc = SparkUtils.getSc(true)
  // sc.newAPIHadoopRDD()

  val tokenized = sc.textFile("data/data.txt").flatMap(_.split(' ')).map(x => (x, 1))
  tokenized.coalesce(4, true)
}
