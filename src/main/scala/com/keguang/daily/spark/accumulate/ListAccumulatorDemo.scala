package com.keguang.daily.spark.accumulate

import java.util.concurrent.LinkedBlockingDeque

import com.keguang.daily.spark.utils.SparkUtils

/**
  * @Author:keguang
  * @Date:2018 /10/29 9:32
  * @version v1.0.0
  */
object ListAccumulatorDemo extends App {
  val sparkContext = SparkUtils.getSc(true)
  val queue = new LinkedBlockingDeque[String]
  val data = sparkContext.parallelize(List("1", "2", "3", "4"), 2)

  var list = sparkContext.collectionAccumulator[String]("")

  println(list.value)

  data.foreach(x => {
    list.add(x)
  })

  /*var iterable =  list.value.iterator()
  while (iterable.hasNext){
    queue.put(iterable.next())
  }
  while (queue.size()>0){
    println("1-->"+queue.remove())
  }*/

  println(list.value)

  for(i <- 0.to(list.value.size() - 1)){
    println(list.value.get(i))
  }


}
