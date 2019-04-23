package com.keguang.daily.scala

/**
  * @ Author: keguang
  * @ Date: 2019/2/20 13:50
  * @ version: v1.0.0
  * @ description: 
  */
object CaseClassDemo {
  def main(args: Array[String]): Unit = {
    val p = new ImmutablePerson("keguang", 23)
    println(p.name + "-----" + p.age)
    p match {
      case ImmutablePerson(name:String, age: Int) => println("ImmutablePerson.")
      case _ => println("None.")
    }
  }
}

case class ImmutablePerson(name:String, age: Int)