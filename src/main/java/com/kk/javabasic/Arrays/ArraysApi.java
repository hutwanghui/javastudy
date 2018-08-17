package com.kk.javabasic.Arrays;

import com.kk.algorithm.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ArraysApi {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 56, 4, 3, 2);
        System.out.println(list);
        //会报 java.lang.UnsupportedOperationException，因为通过asList方法得到的List是只读的
        //list.add(9);
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 7));
        System.out.println(list2);
        list2.add(88);
        System.out.println(list2);

        int[] ints = ArrayUtils.generateRandomArray(50, 100);
        //综合排序
        //大数据量的基本数据类型排序=>quick
        //大数据量的自定义类型排序=>merge。
        // 原因：稳定性（相同的值排序前后位置不变），
        // 基本数据类型的稳定性没有意义且排序速度快因此用quick，
        // 但是在引用数据类型中稳定性是有意义的所以用稳定的排序算法merge
        //数据量小=>insert
        ArrayUtils.printIntArray(ints);
        Arrays.sort(ints);
        ArrayUtils.printIntArray(ints);

        Student student = new Student(1, "框框", 20);
        Student student1 = new Student(3, "框框2", 14);
        Student student2 = new Student(2, "框框3", 16);

        Student[] students = new Student[]{student, student1, student2};
        //Student{id=1, name='框框', age=20} Student{id=3, name='框框2', age=14} Student{id=2, name='框框3', age=16}
        //Student{id=1, name='框框', age=20} Student{id=2, name='框框3', age=16} Student{id=3, name='框框2', age=14}     ArrayUtils.printArray(students);
        ArrayUtils.printArray(students);
        //升序写法。降序只需要s2-s1
        Arrays.sort(students, (Student s1, Student s2) -> s1.getId() - s2.getId());
        ArrayUtils.printArray(students);
        //lambda表达式写法
        ArrayUtils.printArray(students);
        Arrays.sort(students, (Student s1, Student s2) -> s1.getAge() - s2.getAge());
        ArrayUtils.printArray(students);
    }
}
