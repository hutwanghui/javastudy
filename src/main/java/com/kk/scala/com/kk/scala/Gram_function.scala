package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/6/24.
  */
object Gram_function {
  def main(args: Array[String]): Unit = {
    var x = add(1, 2)
    var y = add_simple(2, 3)
    var z = use_function(3, 3, f1)
    var z_2 = use_function(3, 3, f2)
    println(s"${x} : ${y} : ${z} : ${z_2}")
    //将方法转换成函数：神奇的下划线
    val m = add _
    println(s"m = ${m}")

    println(s"change_args_function(1,2,3) = ${change_args_function(1, 2, 3)}")
    println(s"change_args_function(1,2) = ${change_args_function(1, 2)}")
    println(s"change_args_function(1) = ${change_args_function(1)}")

  }

  //申明成了一个方法
  def add(x: Int, y: Int): Int = {
    x + y
  }

  def add_simple(x: Int, y: Int) = x + y

  def use_function(m: Int, n: Int, f: (Int, Int) => Int) = f(m, n)

  //可变参数
  def change_args_function(args: Int*) = {
    var result = 0
    for (i <- args) result += i
    result
  }

  //匿名函数
  //定义函数，函数是头等公民，可以可以像任何其他数据类型一样被传递和操作
  val f1 = (x: Int, y: Int) => x + y
  //再定义一个函数f2
  val f2 = (m: Int, n: Int) => m * n

  //懒值
  
}
