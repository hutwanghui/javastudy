package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/7/7.
  */
object Gram_test_class {
  def main(args: Array[String]): Unit = {
    val gram_class = new Gram_class
    println(s"gram_class = ${gram_class.toString}")
    val gram_class_constructor = new Gram_class_constructor("Wanhui", 21)
    println(s"gram_class_constructor = ${gram_class_constructor}")
  }
}
