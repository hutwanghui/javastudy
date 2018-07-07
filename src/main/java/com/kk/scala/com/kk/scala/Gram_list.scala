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
    //见List中的每个元素*10后生成一个新的list
    val list_5 = list_1.map(_ * 10)
    println(s"*10以后的list = ${list_5}")
    //反转顺序
    println(s"逆序 = ${list_1.sorted.reverse}")
    //将list中的元素n个一组，类型为Iterator
    val list_iterator = list_1.grouped(2).toList
    println(s"list分组成iterator = ${list_iterator}")
    //将多个list压扁成一个List
    println(s"压扁 = ${list_iterator.flatten}")
    val l1 = ListBuffer(1, 3, 5, 7, 6, 2)
    val l2 = ListBuffer(1, 4, 5, 6, 7, 8, 9)
    val l_l = List(List(1, 2, 3), List(4, 5), List(6), List(7))
    //聚合
    val result = l_l.aggregate(0)(_ + _.sum, _ + _)
    println(s"list聚合 = ${result}")
    val result_2 = l_l.aggregate(10)(_ + _.sum, _ + _)
    println(s"list初值为10的聚合 = ${result_2}")
    //交集
    val r1 = l1.intersect(l2)

    //并集
    val r2 = l1.union(l2)
    println(s"l1与l2的并集 = ${r2}")
    //差集

  }
}
