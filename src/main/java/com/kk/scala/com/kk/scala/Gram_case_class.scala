package com.kk.scala.com.kk.scala

/**
  * Created by hutwanghui on 2018/8/16.
  * email:zjjhwanhui@163.com
  * qq:472860892
  */
case class Score(userId: Int, movieId: String, score: Int)

case class Score2(user: Int, movie: Int, score: Double)

object Gram_case_class {
  def main(args: Array[String]): Unit = {
    val score = new Score(1, "123", 2)
    println(s"score = ${score}")
    val score_2 = new Score2(score.userId, score.movieId.toInt, score.score.toDouble)
    println(s"score_2 = ${score_2}")
  }
}
