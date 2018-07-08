package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/7/4.
  */
//在Scala中，类并不用声明为public。
//Scala源文件中可以包含多个类，所有这些类都具有公有可见性。
//使用private[scala]表示只能在scala包下访问
//如果类名后面再跟一个private，那么范围就只被限定在他的伴生类中
private[scala] class Gram_class private {
  //用val修饰的变量是只读属性，有getter但没有setter
  //（相当与Java中用final修饰的变量）
  val id = "9527"
  //用var修饰的变量既有getter又有setter
  var age: Int = 18

  //类私有字段,只能在类的内部使用,也就是说，在伴生对象或对象之外new出的对象就不可以访问
  private var name: String = "唐伯虎"

  //对象私有字段,访问权限更加严格的，只有Person类的方法只能访问到当前对象的字段，连伴生对象都不可以访问
  private[this] val pet = "小强"

  override def toString = s"Gram_class($id, $age, $name, $pet)"
}

//伴生对象
object Gram_class {
  def main(args: Array[String]): Unit = {
    val gram_class = new Gram_class
    println(gram_class.toString)
  }
}

