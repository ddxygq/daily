package com.keguang.daily.scala

/**
  * @ Author: keguang
  * @ Date: 2019/2/20 11:40
  * @ version: v1.0.0
  * @ description: 
  */
object DemoTest {
  def main(args: Array[String]): Unit = {
    val demo = new Demo("keguang")
    demo.age = 24
    demo.sayHello()
  }

}
