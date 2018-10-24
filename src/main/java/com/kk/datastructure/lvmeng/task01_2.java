package com.kk.datastructure.lvmeng;

/**
 * Created by msi- on 2018/6/10.
 */

import java.io.File;
import java.util.Arrays;

public class task01_2 {
    /********** BEGIN **********/
    public void showDirStructure(File dir) {
        digui(dir);
    }

    public void digui(File file) {
        Math.min(123, 333);
        if (file.isDirectory()) {
            System.out.println("+--" + file.getName());
            System.out.print("  ");
            Arrays.stream(file.listFiles()).forEach(file1 -> digui(file1));
        } else {
            System.out.print("  ");
            System.out.print("--" + file.getName());
            System.out.println("  ");
        }
        System.out.print("  ");
    }

    static void list(File f, int lv) {
        File[] childs = f.listFiles();
        for (int i = 0; i < childs.length; i++) {
            for (int j = 0; j < lv; j++)
                System.out.print(" ┃");
            if (i == childs.length - 1)
                System.out.println(" ┗" + childs[i].getName());
            else
                System.out.println(" ┣" + childs[i].getName());
            if (childs[i].isDirectory())
                list(childs[i], lv + 1);
        }
    }

    static void list2(File f, int lv) {
        File[] childs = f.listFiles();
        for (int i = 0; i < childs.length; i++) {
            for (int j = 0; j < lv; j++)
                System.out.print("  ");
            if (i == childs.length - 1)
                System.out.println("+--" + childs[i].getName());
            else
                System.out.println("--" + childs[i].getName());
            if (childs[i].isDirectory())
                list2(childs[i], lv + 1);
        }
    }

    /********** END **********/
    public static void main(String[] args) {
        task01_2 task01_2 = new task01_2();
        task01_2.list2(new File("C:\\Users\\msi-\\Documents\\Tencent Files\\472860892\\FileRecv\\MobileFile"), 0);
    }
}
