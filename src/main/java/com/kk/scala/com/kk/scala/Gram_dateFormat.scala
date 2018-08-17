package com.kk.scala.com.kk.scala

import java.util.{Date, Locale}
import java.text.DateFormat._

/**
  * Created by msi- on 2018/7/10.
  */

class Gram_dateFormat {

}

object Gram_dateFormat {
  def main(args: Array[String]): Unit = {
    val now = new Date
    print(now)
    //df = 2018年7月10日
    val df = getDateInstance(LONG, Locale.CHINA)
    println(s"df = ${df format now}")
    //10 juillet 2018
    val df2 = getDateInstance(LONG, Locale.FRANCE)
    println(s"df2  ${df2 format now}")
    val df3 = getDateInstance(LONG, Locale.ENGLISH)
    println(s"df3 = ${df3 format now}")
    val df4 = getDateInstance(LONG, Locale.US)
    println(s"df4 = ${df4 format now}")

  }

}
