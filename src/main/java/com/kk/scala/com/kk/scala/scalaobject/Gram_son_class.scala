package com.kk.scala.com.kk.scala.scalaobject

/**
  * Created by msi- on 2018/7/9.
  */
class Gram_son_class extends Gram_parent_class {


}

object Gram_son_class {
  def main(args: Array[String]): Unit = {

    val gram_son_class = new Gram_son_class()
    println(s"继承了父类的非private属性 = ${gram_son_class.id}===${gram_son_class.age}")
  }

}
