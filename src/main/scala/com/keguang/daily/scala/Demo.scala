package com.keguang.daily.scala

/**
  * @ Author: keguang
  * @ Date: 2019/2/20 11:37
  * @ version: v1.0.0
  * @ description: 
  */
class Demo(name: String) {
  var age:Int = 23

  def sayHello(): Unit ={
    println(s"my name is ${name} and this yeay i am ${age} years old.")
  }
}
