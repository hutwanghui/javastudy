package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/7/4.
  */
//每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起
class Gram_class_constructor(val name: String, val age: Int) {
  //主构造器会执行类定义中的所有语句
  println(s"执行主构造器中打印语句")


  override def toString = s"Gram_class_constructor($name, $age)"
}
