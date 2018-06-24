package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/6/24.
  */
object Gram_condition_expression {
  def main(args: Array[String]): Unit = {
    val x = 1
    //判断并赋值
    val y = if (x > 0) x else 0
    println(s"y = ${y}")
    //可以使用混合方式
    val z = if (x > 1) x else "error"
    println(s"z = ${z}")
    //如果没有else的情况，相当于if() x else ()
    val p = if (x > 1) x
    println(s"p = ${p}")
    //也可以使用if..elif..else的多判断条件
    val m = if (x > 1) x else if (x > 0) 666 else "error"
    println(s"m = ${m}")
  }
}
