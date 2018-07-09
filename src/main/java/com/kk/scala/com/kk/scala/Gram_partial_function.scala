package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/7/9.
  * 偏函数：不带match的匹配
  * PartialFunction[输入，输出]
  */
object Gram_partial_function {

  def fun1: PartialFunction[String, Int] = {
    case "one" => {
      println("进入one判断，返回1")
      1
    }
    case "two" => {
      println("进入two判断，返回2")
      2
    }
    case _ => {
      println("超出指定判断，返回默认值")
      3
    }
  }


  //等价于偏函数
  def fun2(num: String): Int = num match {
    case "one" => {
      println("进入one判断，返回1")
      1
    }
    case "two" => {
      println("进入two判断，返回2")
      2
    }
    case _ => {
      println("超出指定判断，返回默认值")
      3
    }
  }

  def main(args: Array[String]): Unit = {
    val result = fun1("one")
    println(s"result = ${result}")
    val result2 = fun2("one")
    println(s"result2=${result2}")
  }
}
