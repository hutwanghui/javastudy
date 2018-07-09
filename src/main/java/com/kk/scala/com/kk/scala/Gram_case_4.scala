package com.kk.scala.com.kk.scala

import scala.util.Random

/**
  * Created by msi- on 2018/7/9.
  * 样例类
  */
//case class是多例的必须带有构造参数
case class sparkTask(id: String, name: String)

case class TimeTask(time: Long)

//case object是单例的，可以不根构造参数
case object CheckTimeTask

object Gram_case_4 {
  def main(args: Array[String]): Unit = {
    val TaskArray = Array(CheckTimeTask, sparkTask("1", "wordCount"), sparkTask("2", "FPGrowth"), TimeTask(10000))
    TaskArray(Random.nextInt(TaskArray.length)) match {
      case sparkTask(id, name) => {
        println(s"执行spark任务${id}::${name}")
      }
      case TimeTask(time) => {
        println("执行计时相关任务")
      }
      case CheckTimeTask => {
        println("检查任务")
      }

    }
  }
}
