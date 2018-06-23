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
        if (file.isDirectory()) {
            System.out.println("+--" + file.getName());
            System.out.print("  ");
            Arrays.stream(file.listFiles()).forEach(file1 -> digui(file1));
        } else {
            System.out.print("  ");
            System.out.print("--" + file.getName());
            System.out.println("  ");
        }
    }
    /********** END **********/
    public static void main(String[] args) {
        task01_2 task01_2 = new task01_2();
        task01_2.showDirStructure(new File("C:\\Users\\msi-\\Documents\\Tencent Files\\472860892\\FileRecv\\MobileFile"));
    }
}
