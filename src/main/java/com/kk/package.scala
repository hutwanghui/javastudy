package com

/**
  * Created by msi- on 2018/6/3.
  */
package object kk {

  def main(args: Array[String]): Unit = {
    System.out.print("打印")
    //因为Gram_class被限定为Private[scala]，所以不在一个包下的Obejct无法访问
    //val gram_class= new Gram_class
  }
}
