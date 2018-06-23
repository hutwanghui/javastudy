package com.kk.javabasic.Thread.sync.ObjectNotThisLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyService {
    private String usernameParam;
    private String passwordParam;
    private String anyString = new String();

    public void setUsernamePassword(String username, String password) {
        try {
            synchronized (anyString) {
                System.out.println("线程：" + Thread.currentThread().getName() + "进入同步代码块" + System.currentTimeMillis());
                usernameParam = username;
                passwordParam = password;
                Thread.sleep(2000);
                System.out.println("线程：" + Thread.currentThread().getName() + "离开同步代码块" + System.currentTimeMillis());
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
