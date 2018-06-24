package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/6/24.
  */
object Gran_ {
  def main(args: Array[String]): Unit = {
    //集合中表当前this元素
    val newArry = (1 to 10).map(_ * 2)
    println(newArry)
    //包裹有值
    val value = Some("a")
    val result = value match {
      case Some(_) => 1
      case a => 2
      case _ => "result"
    }
    println(result)
    //用作队列
    val value_1 = 1 to 5
    val result_1 = value_1 match {
      case Seq(_, _*) => 1
      case _ => "result"
    }
    println(result_1)
  }

}
