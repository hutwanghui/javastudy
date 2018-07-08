package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/7/8.
  */
class Gram_class_single(val sex: String) {
  private var username: String = _
  private var passsword: String = _

  def this(username: String, password: String) {
    this("male")
    this.username = username
    this.passsword = password
  }

  override def toString = s"Gram_class_single($username, $passsword, $sex)"
}

object Gram_class_single {

  def apply(sex: String): Gram_class_single = new Gram_class_single(sex)

  def apply(username: String, password: String): Gram_class_single = new Gram_class_single(username, password)

  def main(args: Array[String]): Unit = {
    val gram_1 = Gram_class_single
    println(s"gram_1 = ${gram_1.toString}")
    val gram_2 = Gram_class_single("male")
    println(s"gram_2 = ${gram_2.toString}")
    val gram_3 = Gram_class_single("wanghui", "jh123456")
    println(s"gram_3 = ${gram_3.toString}")
  }
}
