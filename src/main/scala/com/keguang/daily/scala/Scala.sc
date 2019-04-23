class Name(s: String){
  private var _value: String = s //不可见的字段，在本例中声明为可变变量。
  def value: String = _value //getter，即读方法。
  def value_= (newValue: String): Unit = _value = newValue //setter，即写方法。
}

val name = new Name("lucky")
println(name.value)
name.value = "helen"
println(name.value)
name.value_=("keguang")
println(name.value)

// 调用父类构造器与良好的面向对象设计
case class Person(name: String, age: Int)
class KeGuang(name: String, age: Int, code: String) extends Person(name, age){
  override def toString = s"KeGuang($name, $age, $code)"
}

object KeGuang{
  def main(args: Array[String]): Unit = {
    val kg = new KeGuang("keguang", 23, "java")
    println(kg)
  }
}