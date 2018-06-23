package com.kk.scala

/**
  * Created by msi- on 2018/6/3.
  */
class Student(Iid: Int, Iname: String, Iemail: String) {
  val id = Iid
  val name = Iname
  val email = Iemail

  override def toString = s"Student($id, $name, $email)"
}
