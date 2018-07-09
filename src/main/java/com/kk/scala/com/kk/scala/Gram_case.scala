package com.kk.scala.com.kk.scala

import scala.util.Random

/**
  * Created by msi- on 2018/7/9.
  * 匹配字符串
  */
object Gram_case {
  def main(args: Array[String]): Unit = {
    val array = Array("Game1", "Game2", "Game3", "Game4")
    val choose = array(Random.nextInt(array.length))
    choose match {
      case "Game1" => println("求生之路2")
      case "Game2" => println("绝地求生")
      case "Game3" => println("LOL")
      case "Game4" => println("MapleStory")
      case _ => println("Not found Game in this Internet bar")
    }
  }
}
