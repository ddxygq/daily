package com.keguang.daily.spark.sql

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * @ Author: keguang
  * @ Date: 2019/1/23 15:53
  * @ version: v1.0.0
  * @ description: 
  */

case class People(var name:String, var age:Int)

object DataFrameDemo {
  def main(args: Array[String]): Unit = {
    demo2()
  }

  def demo2(): Unit ={
    val spark = SparkSession
      .builder()
      .appName("sparkSqlDemo")
      .master("local[*]")
      //.enableHiveSupport()
      .getOrCreate()

    val df:DataFrame = spark.sqlContext.read.json("data/json/people.txt")

    df.createOrReplaceTempView("people")

    // 查看Schema
    df.printSchema()
    df.filter(df("age") > 23).show()
    // spark.sqlContext.sql("select age,count(*) cou from people group by age").coalesce(2).write.json("data/json/people_json")
    // spark.sqlContext.sql("select age,count(*) cou from people group by age").coalesce(2).write.parquet("data/json/people_parquet")
  }

  def demo(): Unit ={
    val spark = SparkSession
      .builder()
      .appName("sparkSqlDemo")
      .master("local[*]")
      //.enableHiveSupport()
      .getOrCreate()

    val peopleRDD = spark.sparkContext.textFile("data/people.txt")
      .map(line => {
        val words = line.split(" ")
        People(words(0), words(1).trim.toInt)
      })

    import spark.sqlContext.implicits._

    // 将RDD转换成DataFrame
    // val df = peopleRDD.toDF("name", "age")
    val df = peopleRDD.toDF("name", "age")
    df.createOrReplaceTempView("people")
    spark.sqlContext.sql("select age,count(*) cou from people group by age").show()
  }
}
