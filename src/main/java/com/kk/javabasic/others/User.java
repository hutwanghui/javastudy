package com.kk.javabasic.others;

import java.io.*;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 序列化：把对象转换为字节序列的过程称为对象的序列化。
 * 反序列化：把字节序列恢复为对象的过程称为对象的反序列化。
 * 当你想把的内存中的对象状态保存到一个文件中或者数据库中时候；
 * 当你想用套接字在网络上传送对象的时候；
 */
public class User implements Serializable {
    private int id;
    private String name;
    //transient关键字能够让这个字段不会被序列化
    private transient String password;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }


    public static void serializeUser(User user) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("F://javastudy/user.txt"));
            oos.writeObject(user);
            System.out.println("user 对象序列化成功！");
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static User deserializeUser() {
        ObjectInputStream ois = null;
        User user = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("F://javastudy/user.txt"));
            user = (User) ois.readObject();
            System.out.println("user 对象反序列化成功！");
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("王回");
        user.setPassword("wh970121");
        user.setAge(22);
        System.out.println("序列化前的对象：" + user.toString());
        serializeUser(user);
        User user1 = deserializeUser();
        System.out.println("序列化后前的对象：" + user1.toString());
    }
}
