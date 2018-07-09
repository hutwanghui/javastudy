package com.kk.scala.com.kk.scala.scalaobject

/**
  * Created by msi- on 2018/7/8.
  */
class Gram_parent_class {
  val id = "9527"
  //用var修饰的变量既有getter又有setter
  var age: Int = 18

  //类私有字段,只能在类的内部使用,也就是说，在伴生对象或对象之外new出的对象就不可以访问
  private var name: String = "唐伯虎"

  //对象私有字段,访问权限更加严格的，只有Person类的方法只能访问到当前对象的字段，连伴生对象都不可以访问
  private[this] val pet = "小强"

}

object Gram_parent_class {
}
