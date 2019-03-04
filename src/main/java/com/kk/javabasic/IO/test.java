package com.kk.javabasic.IO;

/**
 * Created by hutwanghui on 2019/3/4.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1L, "boss", 20,null));
        list.add(new Employee(2L, "财务部大佬", 20, 1L));
        list.add(new Employee(3L, "项目部大佬", 20, 1L));
        list.add(new Employee(4L, "人事部大佬", 20, 1L));
        list.add(new Employee(5L, "财务部小头目1", 20, 2L));
        list.add(new Employee(6L, "项目部小头目1", 20, 3L));
        list.add(new Employee(7L, "人事部小头目1", 20, 4L));
        list.add(new Employee(8L, "e1", 20, 5L));
        list.add(new Employee(9L, "e2", 20, 5L));
        list.add(new Employee(10L, "e3", 20, 5L));
        list.add(new Employee(11L, "e4", 20, 6L));
        list.add(new Employee(12L, "e5", 20, 6L));
        list.add(new Employee(13L, "e6", 20, 6L));
        list.add(new Employee(14L, "e7", 20, 7L));
        list.add(new Employee(15L, "e8", 20, 7L));
        list.add(new Employee(16L, "e9", 20, 7L));
        printTree(list, list, 0L);
    }

    public static List<Employee> find(List<Employee> emp, Long emp_id) {
        List<Employee> list = new ArrayList<Employee>();
        for (Employee e : emp) {
            if (e.leader_id == emp_id) {
                list.add(e);
            }
        }
        return list;
    }

    public static void printTree(List<Employee> list, List<Employee> basic, long level) {
        for (Employee var : list) {
            System.out.println(printTree(level) + var);
            List<Employee> branchList = find(basic, var.id);
            if (branchList.size() == 0) {
//                System.out.println("done");
            } else {
                level++;
                printTree(branchList, basic, level);
                level--;
            }
        }
    }

    public static String printTree(long level) {
        StringBuilder tree = new StringBuilder("|--");
        for (int i = 0; i < level; i++) {
            tree.append("|--");
        }
        return tree.toString();
    }
}
