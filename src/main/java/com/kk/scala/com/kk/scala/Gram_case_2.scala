package com.kk.scala.com.kk.scala

import scala.util.Random

/**
  * Created by msi- on 2018/7/9.
  * 匹配类型
  */

object Gram_case_2 {
  def main(args: Array[String]): Unit = {
    val array = Array("敲里吗", 3.14, 1, -2, 0, Gram_case, true)
    val choose = array(Random.nextInt(array.length))
    choose match {
      case w: Double => println("类型是Double:" + w)
      case x: Int if (x > 0) => println("类型是Int:" + x)
      case y: Boolean => println("类型是Boolean:" + y)
      case z: String => println("类型是String:" + z)
      case _ => println("Unknown Type")
    }

  }
}
