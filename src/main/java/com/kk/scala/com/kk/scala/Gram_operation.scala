package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/6/24.
  */
object Gram_operation {
  def main(args: Array[String]): Unit = {
    val a = 1
    val b = 2
    //四则运算
    var add = a.+(b)
    println(s"${a} + ${b} = ${add}")
    var sub = a.-(b)
    println(s"${a} - ${b} = ${sub}")
    var mul = a.*(b)
    println(s"${a} * ${b} = ${mul}")
    var div = a./(b)
    println(s"${a} / ${b} = ${div}")
    //逻辑运算
    var flag = true
    var and: Boolean = flag.&(a > 0)
    println(s"and = ${and}")
    var or = flag.|(a < 0)
    println(s"or = ${or}")
  }
}
