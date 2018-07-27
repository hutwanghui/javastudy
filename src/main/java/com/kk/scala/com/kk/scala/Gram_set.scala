package com.kk.scala.com.kk.scala

/**
  * Created by msi- on 2018/6/24.
  */
case class Book(id: Int, name: String, size: Int)

object Gram_set {
  def main(args: Array[String]): Unit = {
    //最大和最小值
    val numbers = Seq(12, 3, 2, 1, 6, 7, 8)
    val numbers_max = numbers.max
    val numbers_min = numbers.min
    println(s"最大值 = ${numbers_max} \n最小值 = ${numbers_min}")
    val books = Seq(Book(11, "百年孤独", 100000), Book(3, "傲慢与偏见", 233333), Book(5, "大数据实战", 99999))
    val books_max = books.maxBy(b => b.id)
    val books_max_byName_length = books.maxBy(b => b.name.length)
    println(s"id最大 = ${books_max}  \n书名长度最大 = ${books_max_byName_length}")
    //筛选过滤(不改变原本，返回新集合)
    val numbers_new = numbers.filter(num => num % 2 == 0)
    println(s"numbers = ${numbers}")
    println(s"numbers_new = ${numbers_new}")
    val books_new = books.filterNot(book => book.id > 5)
    println(s"books_new = ${books_new}")
    //集合压扁
    val abcd = Seq("a", "b", "c", "d")
    val efgh = Seq("e", "f", "g", "h")
    val alphabets = Seq(abcd, efgh)
    println(s"压缩前的集合 = ${alphabets}")
    val alphabets_zip = alphabets.flatten
    println(s"压缩后的集合 = ${alphabets_zip}")
    //map对每个元素进行操作并返回一个新的集合
    val numbers_map = numbers.map(x => x * x)
    println(s"numbers_map = ${numbers_map}")
    //flatMap,由map & flatten组成
    val alphabets_new = alphabets_zip.flatMap(ch => List(ch.toUpperCase, ch))
    println(s"alphabets_new = ${alphabets_new}")
    //集合元素检查
    val seq_flag = numbers.forall(x => x > 0)
    println(s"集合检查结果= ${seq_flag}")
    //partition 集合分组，和flatten是相反的操作
    println(s"分组结果 = ${numbers.partition(x => x % 2 == 0)}")
  }
}
