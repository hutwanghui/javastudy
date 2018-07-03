package com.kk.scala.com.kk.scala

import scala.collection.immutable._

/**
  * Created by msi- on 2018/7/4.
  */
object Gram_list_immutable {
  def main(args: Array[String]): Unit = {
    //定义一个不可变列表，与可变的不同之处就在于，这个列表不能进行改变，改变实际上是新生成一个列表
    val list_1 = List(1, 2, 3)

    //列表连接生成新列表的几种方法
    val list_2 = 5 :: list_1
    val list_3 = list_1.::(6)
    val list_4 = 7 +: list_1
    val list_5 = list_1.+:(8)
    println(s"list_1 = ${list_1}")
    println(s"list_2 = ${list_2}")
    println(s"列表连接 = ${list_3}-${list_4}-${list_5}")
  }
}
