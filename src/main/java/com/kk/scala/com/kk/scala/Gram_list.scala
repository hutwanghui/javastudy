package com.kk.scala.com.kk.scala

import scala.collection.mutable.ListBuffer

/**
  * Created by msi- on 2018/6/24.
  */
object Gram_list {
  def main(args: Array[String]): Unit = {
    //定义可变列表
    val list_1 = ListBuffer[Int](1, 2, 3)
    //不用返回一个新列表，这就是与不可变的区别
    list_1 += 4
    list_1.append(5)


    println(s"list_1 = ${list_1}")
    val list_2 = list_1.filter(_ % 2 == 0).map(_ * 2)
    println(s"list_2 = ${list_2}")

    //列表的连接，会返回一个新的列表
    val list_3 = list_1 ++ list_2
    val list_4 = list_3 :+ 9
    println(s"列表连接 = ${list_3},${list_4}")

  }
}
