package com.kk.scala.com.kk.scala.scalaobject

/**
  * Created by msi- on 2018/7/9.
  */
class Person(name: String, sex: String) extends Animal(name, sex) with ThinkAble {
  private var age: Int = _
  private var height: Int = _
  println("Person类主构造器")

  override def think(): Unit = {
    println(s"我是一个人类，我会思考")
  }

  def this(name: String, sex: String, age: Int, Height: Int) {
    this(name, sex)
    this.age = age
    this.height = Height
    println("Persion类辅助构造器")
  }

}

object Person {
  def main(args: Array[String]): Unit = {
    val person = new Person("Chinese", "male", 18, 180)
    person.think()
    person.eat()
    person.sleep()

  }
}
