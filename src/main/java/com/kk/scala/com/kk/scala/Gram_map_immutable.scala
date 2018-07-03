package com.kk.scala.com.kk.scala

import scala.collection.immutable._

/**
  * Created by msi- on 2018/7/4.
  */
object Gram_map_immutable {
  def main(args: Array[String]): Unit = {
    val student = Map("001" -> "wanghui", "002" -> "kuangkuang", "003" -> "wh")
    println(s"student = ${student}")
    println(s"其中某一位 = ${student("001")}")
    val student_2 = Map(("001", "wanghui"), ("002", "kuangkuang"), ("003", "wkk"))
    println(s"student = ${student}")
    println(s"其中某一位 = ${student("003")}")
    //如果映射中有值就返回值，否则返回默认值
    println(s"另一种取值方式= ${student.get("005")}")
    println(student.getOrElse("005", "找不到啊~~"))
  }
}
