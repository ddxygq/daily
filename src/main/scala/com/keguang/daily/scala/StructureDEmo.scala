package com.keguang.daily.scala

/**
  * @ Author: keguang
  * @ Date: 2019/2/20 14:54
  * @ version: v1.0.0
  * @ description: 
  */
object StructureDEmo {

}

case class Address(street: String, city: String, state: String, zip: String){
  def this(zip: String) = this("[unknown]", Address.zipToCity(zip), Address.zipToState(zip), zip)
}

object Address{
  def zipToCity(zip: String) = "Anytown"
  def zipToState(zip: String) = "CA"
}

case class Person(name: String, age: Option[Int], address: Option[Address]) {
  def this(name: String) = this(name, None, None)
  def this(name: String, age: Int) = this(name, Some(age), None)
  def this(name: String, age: Int, address: Address) = this(name, Some(age), Some(address))
  def this(name: String, address: Address) = this(name, None, Some(address))
}

object Main{
  def main(args: Array[String]): Unit = {
    var address = new Address("lucky")
    var p = new Person("lucky", Some(20), Some(address))
    println(p.name + "---" + p.age.get + "---" + p.address.get)
  }
}