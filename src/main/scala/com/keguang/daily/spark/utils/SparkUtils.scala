package com.keguang.daily.spark.utils

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Author : keguang
  * @Date:2018 /7/31 16:44
  * @version v1.0.0
  */
object SparkUtils {
  /**
    *
    * @param isLocal：传入true表示本地模式
    * @return：SparkContext对象
    */
  def getSc(isLocal:Boolean): SparkContext = {
    val sparkConf = new SparkConf();
    if(isLocal){
      sparkConf.setMaster("local[2]")
    }else{
      sparkConf.setMaster("spark://qcloud-spark01:7077")
      sparkConf.set("spark.testing.memory","2147480000")
    }
    sparkConf.setAppName("SparkDemo")

    val sc = new SparkContext(sparkConf)

    return sc
  }
}
