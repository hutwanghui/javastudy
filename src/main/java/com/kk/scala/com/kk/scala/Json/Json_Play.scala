package com.kk.scala.com.kk.scala.Json

import play.api.libs.json.{JsArray, JsString, Json}


/**
  * Created by msi- on 2018/7/10.
  */
//定义case class
case class Address(province: String, city: String)

case class Person(name: String, emails: List[String], address: Address)


object Json_Play {
  def main(args: Array[String]): Unit = {
    //构造JsonObject对象
    //基本类型值
    val j1 = Json.obj("name" -> JsString("wanghui"))
    println(s"j1 = ${j1}")
    //可以简写成：
    val j2 = Json.obj("name" -> "wanghui")
    println(s"j2 = ${j2}")
    //序列类型值
    val j3 = Json.obj("emails" -> JsArray(Seq(JsString("a"), JsString("b"))))
    println(s"j3 = ${j3}")
    //可以简写成：
    val j4 = Json.obj("emails" -> Seq("a", "b"))
    println(s"j4 = ${j4}")
    val j5 = Json.obj(
      "name" -> "wanghui",
      "emails" -> Json.arr("zjjhwanghui@163.com", "472860892@qq.com"),
      "address" -> Json.obj(
        "province" -> "Zhe Jiang",
        "city" -> "Qu ZHou"
      )
    )
    println(s"j5 = ${j5}")

    //解析字符串
    val city = (j5 \ "address" \ "city").as[String]
    val cityOpt = (j5 \ "address" \ "city").asOpt[String]
    val cityOpt_none = (j5 \ "address1" \ "city").asOpt[String]
    val emails = (j5 \ "emails").as[List[String]]
    println(s"city = ${city}")
    println(s"cityOpt = ${cityOpt}")
    println(s"cityOpt_none = ${cityOpt_none}")
    println(s"emails = ${emails}")

    //声明case class的json转换
    implicit val addressFormat = Json.format[Address]
    implicit val personFormat = Json.format[Person]
    val person = Person("wangkuangkuang", List("zjjhwanghui@163.com", "472860892@qq.com"), Address("ZJ", "QZ"))
    val case_class_to_json = Json.toJson[Person](person)
    println(s"person = ${person}")
    println(s"case_class_to_json = ${case_class_to_json}")

    val json_to_case_class = Json.fromJson[Person](case_class_to_json).get //这个方法JsResult[Person]，这是因为从JSON object到case class的转换可能会发生错误，JsResult有两个子类JsSuccess和JsError，分别用来处理成功和失败两种情况：
    val json_to_case_class2 = case_class_to_json.as[Person]
    val json_to_case_class3 = case_class_to_json.asOpt[Person].get
    println(s"json_to_case_class = ${json_to_case_class}")
    println(s"json_to_case_class2 = ${json_to_case_class2}")
    println(s"pjson_to_case_class3 = ${json_to_case_class3}")


  }
}
