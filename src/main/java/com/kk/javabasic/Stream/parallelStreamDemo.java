package com.kk.javabasic.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hutwanghui on 2018/9/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class parallelStreamDemo {

    private List<User> users = Arrays.asList(new User(2, "张三", "男", 4)
            , new User(1, "张三1", "男", 4)
            , new User(3, "张三3", "男", 1)
            , new User(4, "张三4", "男", 2)
            , new User(5, "张三5", "男", 3)
            , new User(6, "张三6", "男", 4)
            , new User(7, "张三7", "男", 4));

    public List<String> findByClassNum_parall(int classNum) {

        return users.parallelStream()
                .filter(user -> user.getClassNum() == classNum)
                .map(user -> user.getName() + "所在班级：" + user.getClassNum())
                .collect(Collectors.toList());
    }

    public List<String> findByClassNum(int classNum) {
        return users.stream()
                .filter(user -> user.getClassNum() == classNum)
                .map(user -> user.getName() + "所在班级：" + user.getClassNum())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        parallelStreamDemo p = new parallelStreamDemo();
        Long startTime = System.currentTimeMillis();
        List<String> result1 = p.findByClassNum(4);
        System.out.println((System.currentTimeMillis() - startTime) + " : " + result1);
        Long startTime2 = System.currentTimeMillis();
        List<String> result2 = p.findByClassNum_parall(4);
        System.out.println((System.currentTimeMillis() - startTime2) + " : " + result2);
    }

    static class User {
        private int id;
        private String name;
        private String sex;
        private int classNum;

        public User(int id, String name, String sex, int classNum) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.classNum = classNum;
        }

        public int getClassNum() {

            return classNum;
        }

        public void setClassNum(int classNum) {
            this.classNum = classNum;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
