package com.kk.scala.com.kk.scala.scalaobject

/**
  * Created by msi- on 2018/7/9.
  */
class Bird(name: String, sex: String) extends Animal(name, sex) with FlyAble {
  print("Bird类主构造器")

  private var colorFeather: String = _

  def this(birdName: String, birdSex: String, colorFeather: String) {
    this(birdName, birdSex)
    this.colorFeather = colorFeather
    println("Bird类辅助构造器")
  }

}

object Bird {
  def main(args: Array[String]): Unit = {
    val bird = new Bird("麻雀", "母", "褐色毛色")
    bird.fly()

  }
}
