package com.kk.datastructure.lvmeng;

/**
 * Created by msi- on 2018/6/10.
 */
public class task01_yu {

    public int getSum(int num1, int num2) {
        /********** BEGIN **********/
        int result = 0;
        for (int i = num1; i <= num2; i++) {
            result += subcribe(i);
        }
        return result;


        /********** END **********/
    }

    public int subcribe(int num) {
        int temp = 0;
        do {
            temp += num % 10;
        } while ((num = num / 10) > 0);
        return temp;
    }

    public static void main(String[] args) {
        task01_yu task01_yu = new task01_yu();
        System.out.printf("结果" + task01_yu.getSum(15, 19));
    }
}
