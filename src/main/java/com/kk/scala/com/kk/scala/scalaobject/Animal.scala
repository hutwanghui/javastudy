package com.kk.scala.com.kk.scala.scalaobject

/**
  * Created by msi- on 2018/7/9.
  */
abstract class Animal {

  println(s"Animal主构造器")
  var name: String = _
  var sex: String = _

  def this(name: String, sex: String) {
    this()
    this.name = name
    this.sex = sex
    println(s"Animal辅助构造器")
  }


  def run(): Unit = {
    println(s"${name} can run")
  }

  def eat(): Unit = {
    println(s"${name} can eat")
  }

  def sleep(): Unit = {
    println(s"${name} can sleep")
  }
}
