package com.kk.debug;

/**
 * Created by hutwanghui on 2019/2/3.
 * email:zjjhwanhui@163.com
 * qq:472860892
 * if条件判断调试技巧
 */
public class example4 {

    static class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }


    public static void main(String[] args) {
        User user = new User("wanghui1", "wanghui");
        //将Expression设置为user.username=""，既可以进入判断条件
        //将Expression设置为user.user.isEmpty()既可以得到判断结果
        if (user.username.isEmpty()) {
            System.out.println("this user's username is Empty");
        }
        System.out.println("调用结束");
    }

}
