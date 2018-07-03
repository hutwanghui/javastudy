package com.kk.scala.com.kk.scala

import scala.collection.mutable.ArrayBuffer

/**
  * Created by msi- on 2018/6/25.
  */
object Gram_tuple {
  def main(args: Array[String]): Unit = {
    val t, (index_1, index_2, index_3) = ("hadoop", 2.7, true)
    println(s"t = ${t}")
    println(s"元组元素访问= ${t._1}")

    //对偶的元组可以映射成map
    val arr = Array(("Tom", 18), ("Aimli", 20))
    val map = arr.toMap
    println(s"map = ${map}")
    //多值绑定zip,如果两个数组的元素个数不一致，拉链操作后生成的数组的长度为较小的那个数组的元素个数
    val names = Array("Tom", "Legolas", "Linus","abc")
    val scores = Array(60, 90, 100)
    val scores_buffer = ArrayBuffer(66, 77, 88, 99)
    val student = names.zip(scores)
    val student_2 = names.zip(scores_buffer += 50)
    println(s"student = ${student.toBuffer}")
    println(s"student to map = ${student.toMap}")
    println(s"student_2 = ${student_2.toBuffer}")

  }
}
