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
    demo3()
  }

  def demo3(): Unit ={
    val spark = SparkSession
      .builder()
      .appName("sparkSqlDemo")
      .master("local[*]")
      //.enableHiveSupport()
      .getOrCreate()

    val people = spark.sparkContext.textFile("data/people.txt")

    // 以字符串格式创建编码模式，假设一个表的字段结构
    val schemaString = "name age"

    // 导入行功能
    import org.apache.spark.sql.Row

    // 导入SQl数据类型
    import org.apache.spark.sql.types.{StructType, StructField, StringType}

    // 将整个字符串以空格作为分隔符来读取每个字段，并且默认情况下，每个字段类型为String类型
    val schema=StructType(schemaString.split(" ").map(fieldName=>StructField(fieldName,StringType,true)))

    val rowRDD = people.map(x => x.split(" ")).map(p => Row(p(0), p(1).trim))

    val pDataFrame = spark.sqlContext.createDataFrame(rowRDD, schema)

    pDataFrame.createOrReplaceTempView("peopleTempTab")

    // 查看Schema
    pDataFrame.printSchema()
    pDataFrame.filter(pDataFrame("age") > 23).show()
    spark.sqlContext.sql("select * from peopleTempTab where age > 23").show()
    // spark.sqlContext.sql("select age,count(*) cou from people group by age").coalesce(2).write.json("data/json/people_json")
    // spark.sqlContext.sql("select age,count(*) cou from people group by age").coalesce(2).write.parquet("data/json/people_parquet")
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
