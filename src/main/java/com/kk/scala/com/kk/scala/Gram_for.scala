package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/6/24.
  */
object Gram_for {
  def main(args: Array[String]): Unit = {
    var list = List(1, 2, 3)
    //普通for
    for (x <- list) {
      println(s"普通for:x = ${x}")
    }
    //带循环区间的for，这个区间前后值都取
    for (x <- -1 to 3) {
      println(s"普通for：x = ${x}")
    }
    //带判断的for
    for (x <- list if (x / 2 == 0)) {
      println(s"高级for:x = ${x}")
    }
    //带中间变量绑定的for
    for (x <- list; a = x + 1; y <- List(4, 5, 6)) {
      println(s"高级for:x = ${x}:${a}:${y}")
    }
    //yield-for
    val result = for {
      x <- list
      result = x + 1
    } yield result
    println("新生成的yield列表" + result)
    //使用foreach做遍历
    list.foreach(index => println(s"index = ${index}"))
  }
}
