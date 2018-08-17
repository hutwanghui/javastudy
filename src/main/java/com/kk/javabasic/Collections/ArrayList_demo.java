package com.kk.javabasic.Collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ArrayList_demo {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        Person person = new Person(1, "Wanghui", 21);
        Person person1 = new Person(2, "kuangkuang", 19);
        Person person2 = Person.getInstance();
        person2.setId(6);
        person2.setAge(20);
        person2.setName("JiaMing");
        list.add(person);
        list.add(person1);
        list.add(person2);
        System.out.println(list.toString());
        list.sort((p1, p2) -> p1.getAge() - p2.getAge());
        Person person3 = Person.getInstance();
        list.add(person3);
        System.out.println(list.toString());
    }
}
