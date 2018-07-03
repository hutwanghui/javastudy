package com.kk.scala.com.kk.scala

import scala.collection.mutable.ArrayBuffer

/**
  * Created by msi- on 2018/6/24.
  */
object Gram_array {
  def main(args: Array[String]): Unit = {
    //使用val定义不可修改的常量，相当于java的final
    val x = 1
    //使用var定义的可修改的变量，Scala编译器会自动推断变量的类型，当然也可以自行指定
    var y = 1
    //指定类型的定义方法：变量名在前，类型在后
    var z: Int = 3
    //x=2 ;在编译期就会报错
    //定长数组：
    val arry_1 = new Array[Int](8)
    val arry_2 = Array.apply(1, 2, 3)
    //直接打印：内容为一个hashcode，转换成数组缓冲就可以看到原始内容
    //arry_1 = ArrayBuffer(0, 0, 0, 0, 0, 0, 0, 0)
    println(s"arry_1 = ${arry_1.toBuffer}")
    println(s"arry_2 = ${arry_2.toBuffer}")
    println(s"arry_1下标访问数组元素= ${arry_1(0)}")
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //变长数组：又称为数组缓冲，需要导入import scala.collection.mutable.ArrayBuffer包
    var arry_buffer = ArrayBuffer[Int]()
    println(s"arry_buffer = ${arry_buffer}")
    //使用+=在尾部添加元素
    arry_buffer += 1
    arry_buffer.append(2)
    println(s"arry_buffer = ${arry_buffer}")
    //追加多个元素
    arry_buffer += (3, 4, 5, 6, 7)
    println(s"arry_buffer = ${arry_buffer}")
    //追加一个数组
    arry_buffer ++= Array(8, 9)
    println(s"arry_buffer = ${arry_buffer}")
    //在某位置插入
    arry_buffer.insert(1, 10)
    println(s"arry_buffer = ${arry_buffer}")

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //数组遍历小技巧：使用until将长度转换成range，这样就不需要使用 to length-1了
    for (i <- (0 until arry_buffer.length).reverse)
      println("小技巧：" + arry_buffer(i))
    for (i <- 0 to arry_buffer.length - 1)
      println("普通：" + arry_buffer(i))

    //数组转换，filter是过滤，接收一个返回值为boolean的函数,map相当于将数组中的每一个元素取出来，应用传进去的函数,_表示元素
    var array_change = arry_buffer.filter(_ % 2 == 0).map(_ * 10)
    println(s"array_change = ${array_change.toBuffer}")
    //数组api
    println(s"求和 = ${array_change.sum}")
    println(s"最大值 = ${array_change.max}")
    println(s"排序 = ${array_change.sorted}")
    println(s"array_change = ${array_change.stringPrefix}")
    println(s"排序小到大= ${array_change.sortWith(_ < _)}")
    println(s"计数大于50的元素个数 = ${array_change.count(_ > 50)}")
  }
}
