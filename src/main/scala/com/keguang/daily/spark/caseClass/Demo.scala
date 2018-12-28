package com.keguang.daily.spark.caseClass

/**
  * @Author:keguang
  * @Date:2018 /8/7 10:41
  * @version v1.0.0
  */
object Demo extends App {
  case class Person(private val parent:Person = null, private val name:String = null,
  private var age:Int = 0){
    def setName(newName:String) = new Person(this, newName, this.age)
    def setAge(newAge:Int):this.type = {
      this.age = newAge
      this
    }

    def introduce: Unit ={
      parentIntroduce
      println(s"Hello ,my name is ${name} and I am $age years old.")
    }

    def parentIntroduce: Unit ={
      if(parent != null){
        parent.introduce
      }
    }
  }

  Person(null, "kitty", 45).setName("Peter").setAge(41).setName("Peter1").setAge(21).introduce

  Person(null, "kitty", 45).setAge(41).setName("Peter").setName("Peter1").setAge(21).introduce

}
