package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/6/24.
  */
object Gram_list {
  def main(args: Array[String]): Unit = {
    val list_1 = List.apply(1, 2, 3)
    println(s"list_1 = ${list_1}")

    val list_2 = list_1.filter(_ % 2 == 0).map(_ * 2)
    println(s"list_2 = ${list_2}")
  }
}
