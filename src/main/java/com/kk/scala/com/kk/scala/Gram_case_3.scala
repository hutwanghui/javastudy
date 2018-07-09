package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/7/9.
  * 匹配数组、列表、元组
  */
object Gram_case_3 {
  def main(args: Array[String]): Unit = {
    val array = Array(3, 2, 3)
    array match {
      case Array(1, x, y) => println(x + "----" + y)
      case Array(2, 2, 3) => println("完全匹配")
      case Array(3, _*) => println("首位匹配")
      case _ => println("不匹配")
    }

    //    val list=List(1,2,3,4,5)
    //    val list = List(3, 4, 5)
    //    val list = List(0, 2, 3, 4, 5)
    val list = List(1, 3, 4, 0)
    list match {
      case 1 :: 2 :: 3 :: 4 :: 5 :: Nil => println("完全匹配")
      case x :: y :: z :: Nil => println("匹配长度为3的列表")
      case 0 :: tail => println("匹配以0为开头，长度不确定的列表")
      case x if (x.last == 0) => println("匹配以0结尾，长度不确定的列表")

      case _ => println("SomeThing Else")
    }

    val tuple = (2, "String", true)
    tuple match {
      case (1, x, y) => println("匹配第一个元素是1的元组")
      case x if x._2.isInstanceOf[String] => println("类型匹配String")
      case _ => println("匹配不上啊")
    }

  }
}
