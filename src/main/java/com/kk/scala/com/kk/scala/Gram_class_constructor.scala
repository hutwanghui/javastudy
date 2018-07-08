package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/7/4.
  */
//每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起,主构造器中的代码都会被执行，方法会被声明但是不会被调用
//使用val，只有getter
//使用var,有getter和setter
//不使用val和var，相当于private[this]
class Gram_class_constructor(var name: String, val age: Int, gender: String, mobile: String = "18042261719") {
  //主构造器会执行类定义中的所有语句
  println(s"执行主构造器中打印语句")

  private var username: String = _
  private var password: String = _

  //辅助构造器定义,用this关键字定义
  //每个辅助构造器必须以主构造器或其他的辅助构造器的调用开始
  def this(username: String, password: String) {
    this("default", 18, "male")
    this.username = username
    this.password = password
  }

  override def toString = s"Gram_class_constructor($username, $password, $name, $age)"
}

object Gram_class_constructor {
  def main(args: Array[String]): Unit = {
    val gram_class_constructor_zhu = new Gram_class_constructor("wanghui", 21, "male")
    println(s"使用主构造器构造的对象 = ${gram_class_constructor_zhu.toString}")
    val gram_class_constructor_fu = new Gram_class_constructor("wanghui", "jh123456")
    println(s"使用辅助构造器构造的对象 = ${gram_class_constructor_fu.toString}")
  }
}
