package com.kk.scala.com.kk.scala

import scala.collection.mutable

/**
  * Created by msi- on 2018/6/24.
  */
object Gram_map {
  def main(args: Array[String]): Unit = {
    val student = mutable.HashMap("001" -> "wanghui", "002" -> "kuangkuang", "003" -> "wh")
    println(s"student = ${student}")
    println(s"其中某一位 = ${student("001")}")
    student += (("004", "wangkuangkuang"))
     val student_2 = mutable.HashMap(("001", "wanghui")
      , ("002", "kuangkuang")
      , ("003", "wkk")
     )
    println(s"student = ${student}")
    println(s"其中某一位 = ${student("003")}")
    //如果映射中有值就返回值，否则返回默认值
    println(s"另一种取值方式= ${student.get("005")}")
    println(student.getOrElse("005", "找不到啊~~"))
    //可变map可以在原map上添加元素
  }
}