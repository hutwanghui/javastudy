package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/6/9.
  */
class Bar(foo: String) {
  private val foo_2 = foo


  override def toString = s"Bar($foo_2)"
}

object Bar {
  def apply(foo: String) = new Bar(foo)

}
