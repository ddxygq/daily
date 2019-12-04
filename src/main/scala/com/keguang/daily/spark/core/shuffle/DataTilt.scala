package com.keguang.daily.spark.core.shuffle

import com.keguang.daily.spark.utils.SparkUtils

/**
  * @ Author: keguang
  * @ Date: 2019/11/27 16:21
  * @ version: v1.0.0
  * @ description: 数据倾斜
  */
object DataTilt {

  def main(args: Array[String]): Unit = {
    val sc = SparkUtils.getSc(true)
    val samplePairs = sc.textFile("data/data.txt").flatMap(_.split(' ')).map(x => (x, 1)).sample(false, 0.1)
    val sampleCounts = samplePairs.countByKey()
    sampleCounts.foreach(println(_))
  }

}
